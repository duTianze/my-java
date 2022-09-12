package com.dutianze.designpattern.concurrency.readerwriterlock.task;

import java.util.concurrent.locks.Lock;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class Writer implements Runnable {

  private final Lock writeLock;

  private final String name;

  private final long writingTime;

  public Writer(String name, Lock writeLock) {
    this(name, writeLock, 250L);
  }

  public Writer(String name, Lock writeLock, long writingTime) {
    this.name = name;
    this.writeLock = writeLock;
    this.writingTime = writingTime;
  }

  @Override
  public void run() {
    writeLock.lock();
    try {
      write();
    } catch (InterruptedException e) {
      log.info("InterruptedException when writing", e);
      Thread.currentThread().interrupt();
    } finally {
      writeLock.unlock();
    }
  }

  public void write() throws InterruptedException {
    log.info("{} begin", name);
    Thread.sleep(writingTime);
    log.info("{} finished after writing {}ms", name, writingTime);
  }
}
