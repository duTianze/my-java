package com.dutianze.designpattern.game.datalocality;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/17
 */
class GameEntityTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      GameEntity gameEntity = new GameEntity(5);
      gameEntity.start();
      gameEntity.update();
    });
  }
}