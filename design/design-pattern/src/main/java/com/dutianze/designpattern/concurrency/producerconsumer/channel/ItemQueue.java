package com.dutianze.designpattern.concurrency.producerconsumer.channel;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author dutianze
 * @date 2022/8/31
 */
public class ItemQueue {

    private final BlockingQueue<Item> queue;

    public ItemQueue() {
        queue = new LinkedBlockingQueue<>(5);
    }

    public void put(Item item) throws InterruptedException {
        queue.put(item);
    }

    public Item take() throws InterruptedException {
        return queue.take();
    }
}
