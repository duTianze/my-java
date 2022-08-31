package com.dutianze.designpattern.concurrency.threadpool.task;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@Getter
public abstract class Task {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    private final int id;
    private final int timeMs;

    public Task(final int timeMs) {
        this.id = ID_GENERATOR.incrementAndGet();
        this.timeMs = timeMs;
    }

    @Override
    public String toString() {
        return String.format("id=%d timeMs=%d", id, timeMs);
    }
}
