package com.dutianze.designpattern.others.threadpool;

import com.dutianze.designpattern.others.threadpool.task.Task;
import com.dutianze.designpattern.others.threadpool.task.iml.CoffeeMakingTask;
import com.dutianze.designpattern.others.threadpool.task.iml.PotatoPeelingTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@Slf4j
class WorkerTest {

    private static final int TASK_COUNT = 128 * 1024;
    private static final int THREAD_COUNT = 8;

    @Test
    void usage() {
        assertDoesNotThrow(() -> {
            List<Task> tasks = List.of(new PotatoPeelingTask(3), new PotatoPeelingTask(6), new CoffeeMakingTask(2),
                                       new CoffeeMakingTask(6), new PotatoPeelingTask(4), new CoffeeMakingTask(2),
                                       new PotatoPeelingTask(4), new CoffeeMakingTask(9), new PotatoPeelingTask(3),
                                       new CoffeeMakingTask(2), new PotatoPeelingTask(4), new CoffeeMakingTask(2),
                                       new CoffeeMakingTask(7), new PotatoPeelingTask(4), new PotatoPeelingTask(5));

            // Creates a thread pool that reuses a fixed number of threads operating off a shared
            // unbounded queue. At any point, at most nThreads threads will be active processing
            // tasks. If additional tasks are submitted when all threads are active, they will wait
            // in the queue until a thread is available.
            ExecutorService executor = Executors.newFixedThreadPool(3);
            // Allocate new worker for each task
            // The worker is executed when a thread becomes
            // available in the thread pool
            tasks.stream().map(Worker::new).forEach(executor::execute);
            // All tasks were executed, now shutdown
            executor.shutdown();
            while (!executor.isTerminated()) {
                Thread.yield();
            }
            log.info("Program finished");
        });

    }

    @Test
    void workerDoesTheActualJob() {
        final Task task = mock(Task.class);
        final Worker worker = new Worker(task);
        verifyNoMoreInteractions(task);

        worker.run();
        verify(task).getTimeMs();
        verifyNoMoreInteractions(task);
    }

    @Test
    void verifyIfTheGeneratedIdIsUnique() {
        assertTimeout(ofMillis(10000), () -> {
            final ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

            final ArrayList<Callable<Integer>> tasks = IntStream.range(0, TASK_COUNT).<Callable<Integer>>mapToObj(
                    i -> () -> new CoffeeMakingTask(1).getId()).collect(Collectors.toCollection(ArrayList::new));

            final List<Integer> ids =
                    service.invokeAll(tasks).stream().map(WorkerTest::get).filter(Objects::nonNull).toList();
            service.shutdownNow();
            final long uniqueIdCount = ids.stream().distinct().count();

            assertEquals(TASK_COUNT, ids.size());
            assertEquals(TASK_COUNT, uniqueIdCount);
        });
    }

    private static <O> O get(Future<O> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }
}