package com.dutianze.designpattern.others.doubledispatch.entity.monster;

import com.dutianze.designpattern.others.doubledispatch.entity.Entity;
import com.dutianze.designpattern.others.doubledispatch.entity.player.Fighter;
import com.dutianze.designpattern.others.doubledispatch.entity.player.Player;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/14
 */
@Slf4j
public class Monster extends Entity {

  public Monster(int left, int top, int right, int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(Entity entity) {
    entity.collisionResolve(this);
  }

  @Override
  public void collisionResolve(Player player) {
    log.info(HITS + " {} is damaged!", player.getClass().getSimpleName(),
        this.getClass().getSimpleName(), this.getClass().getSimpleName());
    setDamaged(true);
  }

  @Override
  public void collisionResolve(Fighter asteroid) {
    log.info(HITS + " {} is damaged! {} is set on fire!", asteroid.getClass()
            .getSimpleName(),
        this.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getClass()
            .getSimpleName());
    setDamaged(true);
    setOnFire(true);
  }

  @Override
  public void collisionResolve(Monster mir) {
    log.info(HITS + " {} is damaged!", mir.getClass().getSimpleName(),
        this.getClass().getSimpleName(), this.getClass().getSimpleName());
    setDamaged(true);
  }

  @Override
  public void collisionResolve(GreenSlime iss) {
    log.info(HITS, " {} is damaged!", iss.getClass().getSimpleName(),
        this.getClass().getSimpleName(), this.getClass().getSimpleName());
    setDamaged(true);
  }
}
