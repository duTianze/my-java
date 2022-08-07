package com.dutianze.designpattern.builder;

/**
 * @author dutianze
 * @date 2022/8/7
 */
public enum Profession {

    WARRIOR, THIEF, MAGE, PRIEST;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
