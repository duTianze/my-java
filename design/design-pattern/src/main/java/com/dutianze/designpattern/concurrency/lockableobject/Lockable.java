package com.dutianze.designpattern.concurrency.lockableobject;

import com.dutianze.designpattern.concurrency.lockableobject.domain.creature.Creature;

/**
 * @author dutianze
 * @date 2022/9/6
 */
public interface Lockable {

  boolean isLocked();

  boolean lock(Creature creature);

  void unlock(Creature creature);

  Creature getLocker();

  String getName();
}
