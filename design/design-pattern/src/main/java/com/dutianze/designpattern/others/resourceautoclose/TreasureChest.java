package com.dutianze.designpattern.others.resourceautoclose;

import java.io.Closeable;
import lombok.extern.slf4j.Slf4j;

/**
 * Resource Acquisition Is Initialization pattern can be used to implement exception safe resource
 * management.
 *
 * @author dutianze
 * @date 2022/8/28
 */
@Slf4j
public class TreasureChest implements Closeable {

  public TreasureChest() {
    log.info("Treasure chest opens.");
  }

  @Override
  public void close() {
    log.info("Treasure chest closes.");
  }
}
