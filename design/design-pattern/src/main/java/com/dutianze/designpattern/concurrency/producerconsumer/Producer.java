package com.dutianze.designpattern.concurrency.producerconsumer;

import com.dutianze.designpattern.concurrency.producerconsumer.channel.Item;
import com.dutianze.designpattern.concurrency.producerconsumer.channel.ItemQueue;
import java.security.SecureRandom;

/**
 * @author dutianze
 * @date 2022/8/31
 */
public class Producer {

  private final ItemQueue queue;

  private static final SecureRandom RANDOM = new SecureRandom();

  private final String name;
  private int itemId;

  public Producer(String name, ItemQueue queue) {
    this.name = name;
    this.queue = queue;
  }

  public void produce() throws InterruptedException {
    Item item = new Item(name, itemId++);
    queue.put(item);
    Thread.sleep(RANDOM.nextInt(2000));
  }
}
