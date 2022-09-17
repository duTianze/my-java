package com.dutianze.designpattern.game.datalocality.manager.impl;

import com.dutianze.designpattern.game.datalocality.component.Component;
import com.dutianze.designpattern.game.datalocality.component.impl.AiComponent;
import com.dutianze.designpattern.game.datalocality.manager.ComponentManager;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class AiComponentComponentManager implements ComponentManager {

  private static final int MAX_ENTITIES = 10000;

  private final int numEntities;

  private final Component[] aiComponents = new AiComponent[MAX_ENTITIES];

  public AiComponentComponentManager(int numEntities) {
    this.numEntities = numEntities;
  }

  public void start() {
    log.info("Start AI Game Component");
    IntStream.range(0, numEntities).forEach(i -> aiComponents[i] = new AiComponent());
  }

  public void update() {
    log.info("Update AI Game Component");
    IntStream.range(0, numEntities)
        .filter(i -> aiComponents.length > i && aiComponents[i] != null)
        .forEach(i -> aiComponents[i].update());
  }
}
