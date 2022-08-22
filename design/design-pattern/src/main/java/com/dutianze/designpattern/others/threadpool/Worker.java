package com.dutianze.designpattern.others.threadpool;

import com.dutianze.designpattern.others.threadpool.task.Task;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/22
 */
@Slf4j
public class Worker implements Runnable {

    private final Task task;

    public Worker(final Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        log.info("{} processing {}", Thread.currentThread().getName(), task.toString());
        try {
            Thread.sleep(task.getTimeMs());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
