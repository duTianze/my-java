package com.dutianze.designpattern.concurrency.halfasync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author dutianze
 * @date 2022/9/8
 */
@Slf4j
public class AsynchronousService {

    /*
     * This represents the queuing layer as well as synchronous layer of the pattern. The thread pool
     * contains worker threads which execute the tasks in blocking/synchronous manner. Long running
     * tasks should be performed in the background which does not affect the performance of main
     * thread.
     */
    private final ExecutorService service;

    public AsynchronousService(BlockingQueue<Runnable> workQueue) {
        service = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, workQueue);
    }

    public <T> void execute(final AsyncTask<T> task) {
        try {
            // some small tasks such as validation can be performed here.
            task.onPreCall();
        } catch (Exception e) {
            task.onError(e);
            return;
        }

        service.submit(new FutureTask<T>(task) {
            @Override
            protected void done() {
                super.done();
                try {
                    /*
                     * called in context of background thread. There is other variant possible where result is
                     * posted back and sits in the queue of caller thread which then picks it up for
                     * processing. An example of such a system is Android OS, where the UI elements can only
                     * be updated using UI thread. So result must be posted back in UI thread.
                     */
                    task.onPostCall(get());
                } catch (InterruptedException e) {
                    // should not occur
                } catch (ExecutionException e) {
                    task.onError(e.getCause());
                }
            }
        });
    }

    public void close() {
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            log.error("Error waiting for executor service shutdown!");
        }
    }
}
