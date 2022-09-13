package com.dutianze.designpattern.others.doubledispatch.entity;

import com.dutianze.designpattern.others.doubledispatch.Rectangle;
import com.dutianze.designpattern.others.doubledispatch.entity.monster.GreenSlime;
import com.dutianze.designpattern.others.doubledispatch.entity.monster.Monster;
import com.dutianze.designpattern.others.doubledispatch.entity.player.Fighter;
import com.dutianze.designpattern.others.doubledispatch.entity.player.Player;

/**
 * @author dutianze
 * @date 2022/9/14
 */
public abstract class Entity extends Rectangle {

  public static final String HITS = "{} hits {}.";

  private boolean damaged;
  private boolean onFire;

  public Entity(int left, int top, int right, int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public String toString() {
    return String.format("%s at %s damaged=%b onFire=%b", this.getClass().getSimpleName(),
        super.toString(), isDamaged(), isOnFire());
  }

  public boolean isOnFire() {
    return onFire;
  }

  public void setOnFire(boolean onFire) {
    this.onFire = onFire;
  }

  public boolean isDamaged() {
    return damaged;
  }

  public void setDamaged(boolean damaged) {
    this.damaged = damaged;
  }

  public abstract void collision(Entity entity);

  public abstract void collisionResolve(Player player);

  public abstract void collisionResolve(Fighter asteroid);

  public abstract void collisionResolve(Monster mir);

  public abstract void collisionResolve(GreenSlime iss);
}
