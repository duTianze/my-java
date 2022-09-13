package com.dutianze.designpattern.others.doubledispatch.entity.monster;

import com.dutianze.designpattern.others.doubledispatch.entity.Entity;

/**
 * @author dutianze
 * @date 2022/9/14
 */
public class GreenSlime extends Monster {

  public GreenSlime(int left, int top, int right, int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(Entity entity) {
    entity.collisionResolve(this);
  }
}
