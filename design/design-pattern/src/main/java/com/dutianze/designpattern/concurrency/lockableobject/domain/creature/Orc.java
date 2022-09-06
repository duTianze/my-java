package com.dutianze.designpattern.concurrency.lockableobject.domain.creature;

import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureStats;
import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureType;

/**
 * @author dutianze
 * @date 2022/9/6
 */
public class Orc extends Creature {

    public Orc(String name) {
        super(name);
        setType(CreatureType.ORC);
        setDamage(CreatureStats.ORC_DAMAGE.getValue());
        setHealth(CreatureStats.ORC_HEALTH.getValue());
    }
}
