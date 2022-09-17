package com.dutianze.designpattern.game.datalocality.manager.impl;

import com.dutianze.designpattern.game.datalocality.component.Component;
import com.dutianze.designpattern.game.datalocality.component.impl.RenderComponent;
import com.dutianze.designpattern.game.datalocality.manager.ComponentManager;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class RenderComponentManager implements ComponentManager {

  private static final int MAX_ENTITIES = 10000;

  private final int numEntities;

  private final Component[] renderComponents = new RenderComponent[MAX_ENTITIES];

  public RenderComponentManager(int numEntities) {
    this.numEntities = numEntities;
  }

  public void start() {
    log.info("Start Render Game Component ");
    IntStream.range(0, numEntities).forEach(i -> renderComponents[i] = new RenderComponent());
  }

  public void render() {
    log.info("Update Render Game Component ");
    // Process Render.
    IntStream.range(0, numEntities)
        .filter(i -> renderComponents.length > i && renderComponents[i] != null)
        .forEach(i -> renderComponents[i].render());
  }
}

