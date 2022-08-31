package com.dutianze.designpattern.concurrency.threadpool.task.iml;

import com.dutianze.designpattern.concurrency.threadpool.task.Task;

/**
 * @author dutianze
 * @date 2022/8/22
 */
public class PotatoPeelingTask extends Task {

    private static final int TIME_PER_POTATO = 200;

    public PotatoPeelingTask(int numPotatoes) {
        super(numPotatoes * TIME_PER_POTATO);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), super.toString());
    }
}
