package com.dutianze.designpattern.game.datalocality.manager.impl;

import com.dutianze.designpattern.game.datalocality.component.Component;
import com.dutianze.designpattern.game.datalocality.component.impl.PhysicsComponent;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class PhysicsComponentManager {

  private static final int MAX_ENTITIES = 10000;

  private final int numEntities;

  private final Component[] physicsComponents = new PhysicsComponent[MAX_ENTITIES];

  public PhysicsComponentManager(int numEntities) {
    this.numEntities = numEntities;
  }

  public void start() {
    log.info("Start Physics Game Component ");
    IntStream.range(0, numEntities).forEach(i -> physicsComponents[i] = new PhysicsComponent());
  }

  public void update() {
    log.info("Update Physics Game Component ");
    // Process physics.
    IntStream.range(0, numEntities)
        .filter(i -> physicsComponents.length > i && physicsComponents[i] != null)
        .forEach(i -> physicsComponents[i].update());
  }
}
