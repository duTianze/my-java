package com.dutianze.designpattern.structural.flyweight.potion.impl;

import com.dutianze.designpattern.structural.flyweight.potion.Potion;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class HealingPotion implements Potion {

    @Override
    public void drink() {
        log.info("You feel healed. (Potion={})", System.identityHashCode(this));
    }
}