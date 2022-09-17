package com.dutianze.designpattern.game.datalocality.manager;

/**
 * @author dutianze
 * @date 2022/9/17
 */
public interface ComponentManager {

  void start();

  default void update() {
  }

  default void render() {
  }
}
