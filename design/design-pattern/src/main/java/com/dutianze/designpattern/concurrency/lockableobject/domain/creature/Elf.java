package com.dutianze.designpattern.concurrency.lockableobject.domain.creature;

import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureStats;
import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureType;

/**
 * @author dutianze
 * @date 2022/9/6
 */
public class Elf extends Creature {

  public Elf(String name) {
    super(name);
    setType(CreatureType.ELF);
    setDamage(CreatureStats.ELF_DAMAGE.getValue());
    setHealth(CreatureStats.ELF_HEALTH.getValue());
  }
}
