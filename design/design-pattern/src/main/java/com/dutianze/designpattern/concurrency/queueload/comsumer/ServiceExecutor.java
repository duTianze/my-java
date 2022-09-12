package com.dutianze.designpattern.concurrency.queueload.comsumer;

import com.dutianze.designpattern.concurrency.queueload.Message;
import com.dutianze.designpattern.concurrency.queueload.MessageQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/30
 */
@Slf4j
public class ServiceExecutor implements Runnable {

  private final MessageQueue msgQueue;

  public ServiceExecutor(MessageQueue msgQueue) {
    this.msgQueue = msgQueue;
  }

  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        Message msg = msgQueue.retrieveMsg();

        if (msg != null) {
          log.info(msg + " is served.");
        } else {
          log.info("Service Executor: Waiting for Messages to serve .. ");
        }
        Thread.sleep(1000);
      }
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
