package com.dutianze.designpattern.concurrency.producerconsumer;

import com.dutianze.designpattern.concurrency.producerconsumer.channel.Item;
import com.dutianze.designpattern.concurrency.producerconsumer.channel.ItemQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/31
 */
@Slf4j
public class Consumer {

  private final ItemQueue queue;

  private final String name;

  public Consumer(String name, ItemQueue queue) {
    this.name = name;
    this.queue = queue;
  }

  public void consume() throws InterruptedException {
    Item item = queue.take();
    log.info("Consumer [{}] consume item [{}] produced by [{}]", name, item.getId(),
        item.getProducer());
  }
}
