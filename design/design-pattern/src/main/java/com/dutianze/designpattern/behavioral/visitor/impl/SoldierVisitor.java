package com.dutianze.designpattern.behavioral.visitor.impl;

import com.dutianze.designpattern.behavioral.visitor.UnitVisitor;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Commander;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Sergeant;
import com.dutianze.designpattern.behavioral.visitor.unit.impl.Soldier;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class SoldierVisitor implements UnitVisitor {

    @Override
    public void visitSoldier(Soldier soldier) {
        log.info("Greetings {}", soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {
        // Do nothing
    }

    @Override
    public void visitCommander(Commander commander) {
        // Do nothing
    }
}
