package com.dutianze.designpattern.structural.facade.dwarven.impl;

import com.dutianze.designpattern.structural.facade.dwarven.DwarvenMineWorker;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class DwarvenGoldDigger extends DwarvenMineWorker {

  @Override
  public void work() {
    log.info("{} digs for gold.", name());
  }

  @Override
  public String name() {
    return "Dwarf gold digger";
  }
}
