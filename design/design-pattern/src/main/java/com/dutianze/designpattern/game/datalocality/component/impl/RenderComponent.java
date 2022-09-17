package com.dutianze.designpattern.game.datalocality.component.impl;

import com.dutianze.designpattern.game.datalocality.component.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class RenderComponent implements Component {

  @Override
  public void update() {
    // do nothing
  }

  @Override
  public void render() {
    log.info("Render Component");
  }
}
