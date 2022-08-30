package com.dutianze.designpattern.others.queueload.reducer;

import com.dutianze.designpattern.others.queueload.Message;
import com.dutianze.designpattern.others.queueload.MessageQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/30
 */
@Slf4j
public class TaskGenerator implements Task, Runnable {

    private final MessageQueue msgQueue;
    private final int msgCount;

    public TaskGenerator(MessageQueue msgQueue, int msgCount) {
        this.msgQueue = msgQueue;
        this.msgCount = msgCount;
    }

    public void submit(Message msg) {
        try {
            this.msgQueue.submitMsg(msg);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void run() {
        int count = this.msgCount;

        try {
            while (count > 0) {
                String statusMsg = "Message-" + count + " submitted by " + Thread.currentThread().getName();
                this.submit(new Message(statusMsg));

                log.info(statusMsg);

                count--;

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
