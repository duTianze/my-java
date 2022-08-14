package com.dutianze.designpattern.behavioral.visitor.unit;

import com.dutianze.designpattern.behavioral.visitor.UnitVisitor;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public abstract class Unit {

    private final Unit[] children;

    public Unit(Unit... children) {
        this.children = children;
    }

    public void accept(UnitVisitor visitor) {
        Arrays.stream(children).forEach(child -> child.accept(visitor));
    }
}
