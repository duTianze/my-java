package com.dutianze.designpattern.concurrency.queueload;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author dutianze
 * @date 2022/8/30
 */
@Slf4j
public class MessageQueue {

    private final BlockingQueue<Message> blkQueue;

    public MessageQueue() {
        this.blkQueue = new ArrayBlockingQueue<>(1024);
    }

    public void submitMsg(Message msg) {
        try {
            if (msg != null) {
                blkQueue.add(msg);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public Message retrieveMsg() {
        try {
            return blkQueue.poll();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
