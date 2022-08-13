package com.dutianze.designpattern.behavioral.memento;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public enum StarType {
    SUN("sun"),
    RED_GIANT("red giant"),
    WHITE_DWARF("white dwarf"),
    SUPERNOVA("supernova"),
    DEAD("dead star");

    private final String title;

    StarType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}