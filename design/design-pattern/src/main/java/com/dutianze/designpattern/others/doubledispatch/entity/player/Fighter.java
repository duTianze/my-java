package com.dutianze.designpattern.others.doubledispatch.entity.player;

import com.dutianze.designpattern.others.doubledispatch.entity.Entity;

/**
 * @author dutianze
 * @date 2022/9/14
 */
public class Fighter extends Player {

  public Fighter(int left, int top, int right, int bottom) {
    super(left, top, right, bottom);
    setOnFire(true);
  }

  @Override
  public void collision(Entity entity) {
    entity.collisionResolve(this);
  }
}
