package com.dutianze.designpattern.game.updatemethod.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/18
 */
@Slf4j
public abstract class Entity {

  protected int id;

  @Getter
  @Setter
  protected int position;

  public Entity(int id) {
    this.id = id;
    this.position = 0;
  }

  public abstract void update();

}