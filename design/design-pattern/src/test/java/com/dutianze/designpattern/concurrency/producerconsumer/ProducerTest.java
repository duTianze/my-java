package com.dutianze.designpattern.concurrency.producerconsumer;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.dutianze.designpattern.concurrency.producerconsumer.channel.Item;
import com.dutianze.designpattern.concurrency.producerconsumer.channel.ItemQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/31
 */
@Slf4j
class ProducerTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      ItemQueue queue = new ItemQueue();
      ExecutorService executorService = Executors.newFixedThreadPool(5);
      for (int i = 0; i < 2; i++) {
        final Producer producer = new Producer("Producer_" + i, queue);
        executorService.submit(() -> {
          while (true) {
            producer.produce();
          }
        });
      }

      for (int i = 0; i < 3; i++) {
        final Consumer consumer = new Consumer("Consumer_" + i, queue);
        executorService.submit(() -> {
          while (true) {
            consumer.consume();
          }
        });
      }

      executorService.shutdown();
      try {
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        executorService.shutdownNow();
      } catch (InterruptedException e) {
        log.error("Error waiting for ExecutorService shutdown");
      }
    });
  }

  @Test
  void testProduce() {
    assertTimeout(ofMillis(6000), () -> {
      final ItemQueue queue = mock(ItemQueue.class);
      final Producer producer = new Producer("producer", queue);

      producer.produce();
      verify(queue).put(any(Item.class));

      verifyNoMoreInteractions(queue);
    });
  }


  @Test
  void testConsume() throws Exception {
    final int ITEM_COUNT = 5;
    final ItemQueue queue = spy(new ItemQueue());
    for (int id = 0; id < ITEM_COUNT; id++) {
      queue.put(new Item("producer", id));
    }
    reset(queue);

    final Consumer consumer = new Consumer("consumer", queue);
    for (int id = 0; id < ITEM_COUNT; id++) {
      consumer.consume();
    }

    verify(queue, times(ITEM_COUNT)).take();
  }
}