package com.dutianze.designpattern.behavioral.strategy.strategy.impl;

import com.dutianze.designpattern.behavioral.strategy.strategy.DragonSlayingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class ProjectileStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    log.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
  }
}