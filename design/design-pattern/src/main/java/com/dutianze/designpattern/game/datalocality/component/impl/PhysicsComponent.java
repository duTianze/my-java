package com.dutianze.designpattern.game.datalocality.component.impl;

import com.dutianze.designpattern.game.datalocality.component.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class PhysicsComponent implements Component {

  @Override
  public void update() {
    log.info("Update physics component of game");
  }

  @Override
  public void render() {
    // do nothing
  }
}
