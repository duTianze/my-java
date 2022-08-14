package com.dutianze.designpattern.behavioral.strategy.strategy.impl;

import com.dutianze.designpattern.behavioral.strategy.strategy.DragonSlayingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public class SpellStrategy implements DragonSlayingStrategy {

    @Override
    public void execute() {
        log.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!");
    }
}