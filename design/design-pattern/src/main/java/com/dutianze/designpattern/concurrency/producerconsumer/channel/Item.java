package com.dutianze.designpattern.concurrency.producerconsumer.channel;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/31
 */
@Getter
@RequiredArgsConstructor
public class Item {

  private final String producer;
  private final int id;
}
