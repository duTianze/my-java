package com.dutianze.designpattern.behavioral.strategy.strategy.impl;

import com.dutianze.designpattern.behavioral.strategy.strategy.DragonSlayingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class MeleeStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    log.info("With your Excalibur you sever the dragon's head!");
  }
}