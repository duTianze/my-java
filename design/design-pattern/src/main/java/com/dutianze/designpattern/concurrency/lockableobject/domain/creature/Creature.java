package com.dutianze.designpattern.concurrency.lockableobject.domain.creature;

import com.dutianze.designpattern.concurrency.lockableobject.Lockable;
import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureType;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/9/6
 */
@Slf4j
@Data
public abstract class Creature {

  private String name;
  private CreatureType type;
  private int health;
  private int damage;
  Set<Lockable> instruments;

  protected Creature(@NonNull String name) {
    this.name = name;
    this.instruments = new HashSet<>();
  }

  public boolean acquire(@NonNull Lockable lockable) {
    if (lockable.lock(this)) {
      instruments.add(lockable);
      return true;
    }
    return false;
  }

  public synchronized void kill() {
    log.info("{} {} has been slayed!", type, name);
    for (Lockable lockable : instruments) {
      lockable.unlock(this);
    }
    this.instruments.clear();
  }

  public synchronized void attack(@NonNull Creature creature) {
    creature.hit(getDamage());
  }

  public synchronized void hit(int damage) {
    if (damage < 0) {
      throw new IllegalArgumentException("Damage cannot be a negative number");
    }
    if (isAlive()) {
      setHealth(getHealth() - damage);
      if (!isAlive()) {
        kill();
      }
    }
  }

  public synchronized boolean isAlive() {
    return getHealth() > 0;
  }
}

