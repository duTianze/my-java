package com.dutianze.designpattern.concurrency.lockableobject.domain;

import com.dutianze.designpattern.concurrency.lockableobject.Lockable;
import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Creature;
import java.security.SecureRandom;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/6
 */
@Slf4j
public class Feind implements Runnable {

  private final Creature creature;
  private final Lockable target;
  private final SecureRandom random;

  public Feind(@NonNull Creature feind, @NonNull Lockable target) {
    this.creature = feind;
    this.target = target;
    this.random = new SecureRandom();
  }

  @Override
  public void run() {
    if (creature.acquire(target)) {
      log.info("{} has acquired the sword!", target.getLocker().getName());
      return;
    }
    try {
      fightForTheSword(creature, target.getLocker(), target);
    } catch (InterruptedException e) {
      log.error(e.getMessage());
      Thread.currentThread().interrupt();
    }
  }

  private void fightForTheSword(Creature reacher, @NonNull Creature holder, Lockable sword)
      throws InterruptedException {
    log.info("A duel between {} and {} has been started!", reacher.getName(), holder.getName());
    boolean randBool;
    while (target.isLocked() && reacher.isAlive() && holder.isAlive()) {
      randBool = random.nextBoolean();
      if (randBool) {
        reacher.attack(holder);
      } else {
        holder.attack(reacher);
      }
    }
    if (reacher.isAlive()) {
      if (reacher.acquire(sword)) {
        log.info("{} has acquired the sword!", reacher.getName());
        return;
      }
      fightForTheSword(reacher, sword.getLocker(), sword);
    }
  }
}
