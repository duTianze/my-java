package com.dutianze.designpattern.structural.decorator.troll;

import com.dutianze.designpattern.structural.decorator.Troll;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class SimpleTroll implements Troll {

  @Override
  public void attack() {
    log.info("The troll tries to grab you!");
  }

  @Override
  public int getAttackPower() {
    return 10;
  }

  @Override
  public void fleeBattle() {
    log.info("The troll shrieks in horror and runs away!");
  }
}