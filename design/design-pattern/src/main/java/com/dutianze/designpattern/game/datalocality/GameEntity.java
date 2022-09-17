package com.dutianze.designpattern.game.datalocality;

import com.dutianze.designpattern.game.datalocality.manager.impl.AiComponentComponentManager;
import com.dutianze.designpattern.game.datalocality.manager.impl.PhysicsComponentManager;
import com.dutianze.designpattern.game.datalocality.manager.impl.RenderComponentManager;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/17
 */
@Slf4j
public class GameEntity {

  private final AiComponentComponentManager aiComponentManager;
  private final PhysicsComponentManager physicsComponentManager;
  private final RenderComponentManager renderComponentManager;

  public GameEntity(int numEntities) {
    log.info("Init Game with #Entity : {}", numEntities);
    aiComponentManager = new AiComponentComponentManager(numEntities);
    physicsComponentManager = new PhysicsComponentManager(numEntities);
    renderComponentManager = new RenderComponentManager(numEntities);
  }

  public void start() {
    log.info("Start Game");
    aiComponentManager.start();
    physicsComponentManager.start();
    renderComponentManager.start();
  }

  public void update() {
    log.info("Update Game Component");
    // Process AI.
    aiComponentManager.update();

    // update physics.
    physicsComponentManager.update();

    // Draw to screen.
    renderComponentManager.render();
  }
}
