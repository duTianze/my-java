package com.dutianze.designpattern.concurrency.readerwriterlock.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class Reader implements Runnable {

    private final Lock readLock;

    private final String name;

    private final long readingTime;

    public Reader(String name, Lock readLock, long readingTime) {
        this.name = name;
        this.readLock = readLock;
        this.readingTime = readingTime;
    }

    public Reader(String name, Lock readLock) {
        this(name, readLock, 250L);
    }

    @Override
    public void run() {
        readLock.lock();
        try {
            read();
        } catch (InterruptedException e) {
            log.info("InterruptedException when reading", e);
            Thread.currentThread().interrupt();
        } finally {
            readLock.unlock();
        }
    }

    public void read() throws InterruptedException {
        log.info("{} begin", name);
        Thread.sleep(readingTime);
        log.info("{} finish after reading {}ms", name, readingTime);
    }
}
