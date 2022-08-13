package com.dutianze.designpattern.creational.builder.valueobject;

/**
 * @author dutianze
 * @date 2022/8/7
 */
public enum HairColor {

    WHITE,
    BLOND,
    RED,
    BROWN,
    BLACK;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
