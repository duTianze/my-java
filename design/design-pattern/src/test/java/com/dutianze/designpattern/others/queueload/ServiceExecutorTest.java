package com.dutianze.designpattern.others.queueload;

import com.dutianze.designpattern.others.queueload.comsumer.ServiceExecutor;
import com.dutianze.designpattern.others.queueload.reducer.TaskGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/30
 */
@Slf4j
class ServiceExecutorTest {

    private static final int SHUTDOWN_TIME = 15;

    @Test
    void usage() {
        assertDoesNotThrow(() -> {

            // An Executor that provides methods to manage termination and methods that can
            // produce a Future for tracking progress of one or more asynchronous tasks.
            ExecutorService executor;

            try {
                // Create a MessageQueue object.
                MessageQueue msgQueue = new MessageQueue();

                log.info("Submitting TaskGenerators and ServiceExecutor threads.");

                // Create three TaskGenerator threads. Each of them will submit different number of jobs.
                final TaskGenerator taskRunnable1 = new TaskGenerator(msgQueue, 5);
                final TaskGenerator taskRunnable2 = new TaskGenerator(msgQueue, 1);
                final TaskGenerator taskRunnable3 = new TaskGenerator(msgQueue, 2);

                // Create e service which should process the submitted jobs.
                final ServiceExecutor srvRunnable = new ServiceExecutor(msgQueue);

                // Create a ThreadPool of 2 threads and
                // submit all Runnable task for execution to executor..
                executor = Executors.newFixedThreadPool(2);
                executor.submit(taskRunnable1);
                executor.submit(taskRunnable2);
                executor.submit(taskRunnable3);

                // submitting serviceExecutor thread to the Executor service.
                executor.submit(srvRunnable);

                // Initiates an orderly shutdown.
                log.info("Initiating shutdown."
                         + " Executor will shutdown only after all the Threads are completed.");
                executor.shutdown();

                // Wait for SHUTDOWN_TIME seconds for all the threads to complete
                // their tasks and then shut down the executor and then exit.
                if (!executor.awaitTermination(SHUTDOWN_TIME, TimeUnit.SECONDS)) {
                    log.info("Executor was shut down and Exiting.");
                    executor.shutdownNow();
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
    }

    @Test
    void messageQueueTest() {
        MessageQueue msgQueue = new MessageQueue();

        // submit message
        msgQueue.submitMsg(new Message("MessageQueue Test"));

        // retrieve message
        assertEquals("MessageQueue Test", msgQueue.retrieveMsg().getMsg());
    }
}