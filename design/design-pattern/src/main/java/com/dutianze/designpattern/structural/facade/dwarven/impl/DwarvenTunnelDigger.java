package com.dutianze.designpattern.structural.facade.dwarven.impl;

import com.dutianze.designpattern.structural.facade.dwarven.DwarvenMineWorker;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class DwarvenTunnelDigger extends DwarvenMineWorker {

  @Override
  public void work() {
    log.info("{} creates another promising tunnel.", name());
  }

  @Override
  public String name() {
    return "Dwarven tunnel digger";
  }
}
