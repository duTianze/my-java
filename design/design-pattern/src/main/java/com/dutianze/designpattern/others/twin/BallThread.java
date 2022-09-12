package com.dutianze.designpattern.others.twin;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/20
 */
@Slf4j
public class BallThread extends Thread {

  @Setter
  private BallItem twin;

  private volatile boolean isSuspended;
  private volatile boolean isRunning = true;

  public void run() {
    while (isRunning) {
      if (!isSuspended) {
        twin.draw();
        twin.move();
      }
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void suspendMe() {
    isSuspended = true;
    log.info("Begin to suspend BallThread");
  }

  public void resumeMe() {
    isSuspended = false;
    log.info("Begin to resume BallThread");
  }

  public void stopMe() {
    this.isRunning = false;
    this.isSuspended = true;
  }
}