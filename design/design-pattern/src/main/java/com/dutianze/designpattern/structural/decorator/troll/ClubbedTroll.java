package com.dutianze.designpattern.structural.decorator.troll;

import com.dutianze.designpattern.structural.decorator.Troll;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
@RequiredArgsConstructor
public class ClubbedTroll implements Troll {

    private final Troll decorated;

    @Override
    public void attack() {
        decorated.attack();
        log.info("The troll swings at you with a club!");
    }

    @Override
    public int getAttackPower() {
        return decorated.getAttackPower() + 10;
    }

    @Override
    public void fleeBattle() {
        decorated.fleeBattle();
    }
}