package com.dutianze.designpattern.concurrency.lockableobject.domain.types;

/**
 * @author dutianze
 * @date 2022/9/6
 */
public enum CreatureStats {

    ELF_HEALTH(90),
    ELF_DAMAGE(40),

    ORC_HEALTH(70),
    ORC_DAMAGE(50),

    HUMAN_HEALTH(60),
    HUMAN_DAMAGE(60);

    final int value;

    private CreatureStats(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
