package com.dutianze.designpattern.concurrency.lockableobject.domain.creature;

import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureStats;
import com.dutianze.designpattern.concurrency.lockableobject.domain.types.CreatureType;

/**
 * @author dutianze
 * @date 2022/9/6
 */
public class Human extends Creature {

    public Human(String name) {
        super(name);
        setType(CreatureType.HUMAN);
        setDamage(CreatureStats.HUMAN_DAMAGE.getValue());
        setHealth(CreatureStats.HUMAN_HEALTH.getValue());
    }
}
