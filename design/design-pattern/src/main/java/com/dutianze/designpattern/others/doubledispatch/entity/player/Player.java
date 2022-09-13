package com.dutianze.designpattern.others.doubledispatch.entity.player;

import com.dutianze.designpattern.others.doubledispatch.entity.Entity;
import com.dutianze.designpattern.others.doubledispatch.entity.monster.GreenSlime;
import com.dutianze.designpattern.others.doubledispatch.entity.monster.Monster;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/14
 */
@Slf4j
public class Player extends Entity {

  public Player(int left, int top, int right, int bottom) {
    super(left, top, right, bottom);
  }

  @Override
  public void collision(Entity entity) {
    entity.collisionResolve(this);
  }

  @Override
  public void collisionResolve(Player player) {
    log.info(HITS, player.getClass().getSimpleName(), this.getClass()
        .getSimpleName());
  }

  @Override
  public void collisionResolve(Fighter asteroid) {
    log.info(HITS, asteroid.getClass().getSimpleName(), this.getClass()
        .getSimpleName());
  }

  @Override
  public void collisionResolve(Monster mir) {
    log.info(HITS, mir.getClass().getSimpleName(), this.getClass().getSimpleName());
  }

  @Override
  public void collisionResolve(GreenSlime iss) {
    log.info(HITS, iss.getClass().getSimpleName(), this.getClass().getSimpleName());
  }
}
