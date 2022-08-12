package com.dutianze.designpattern.creational.singleton;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/6
 */
abstract class SingletonTest<S> {

    private final Supplier<S> singletonInstanceMethod;

    protected SingletonTest(final Supplier<S> singletonInstanceMethod) {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }

    /**
     * Test the singleton in a non-concurrent setting.
     */
    @Test
    void multipleCallsReturnTheSameObjectInSameThread() {
        // Create several instances in the same calling thread
        var instance1 = this.singletonInstanceMethod.get();
        var instance2 = this.singletonInstanceMethod.get();
        var instance3 = this.singletonInstanceMethod.get();
        // now check they are equal
        assertSame(instance1, instance2);
        assertSame(instance1, instance3);
        assertSame(instance2, instance3);
    }

    /**
     * Test singleton instance in a concurrent setting.
     */
    @Test
    void multipleCallsReturnTheSameObjectInDifferentThreads() throws Exception {
        assertTimeout(ofMillis(10000), () -> {
            // Create 1000 tasks and inside each callable instantiate the singleton class
            final List<Callable<S>> tasks = IntStream.range(0, 1000)
                                                     .<Callable<S>>mapToObj(i -> this.singletonInstanceMethod::get)
                                                     .collect(Collectors.toList());

            // Use up to 8 concurrent threads to handle the tasks
            final ExecutorService executorService = Executors.newFixedThreadPool(8);
            final List<Future<S>> results = executorService.invokeAll(tasks);

            // wait for all the threads to complete
            final S expectedInstance = this.singletonInstanceMethod.get();
            for (Future<S> res : results) {
                final S instance = res.get();
                assertNotNull(instance);
                assertSame(expectedInstance, instance);
            }

            // tidy up the executor
            executorService.shutdown();
        });

    }
}