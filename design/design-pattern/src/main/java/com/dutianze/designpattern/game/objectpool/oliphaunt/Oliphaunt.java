package com.dutianze.designpattern.game.objectpool.oliphaunt;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;

/**
 * @author dutianze
 * @date 2022/9/4
 */
@Data
public class Oliphaunt {

  private static final AtomicInteger counter = new AtomicInteger(0);

  private final int id;

  public Oliphaunt() {
    id = counter.incrementAndGet();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
