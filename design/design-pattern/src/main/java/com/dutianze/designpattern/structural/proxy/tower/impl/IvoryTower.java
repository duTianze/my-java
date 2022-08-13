package com.dutianze.designpattern.structural.proxy.tower.impl;

import com.dutianze.designpattern.structural.proxy.Wizard;
import com.dutianze.designpattern.structural.proxy.tower.WizardTower;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class IvoryTower implements WizardTower {

    public void enter(Wizard wizard) {
        log.info("{} enters the tower.", wizard);
    }
}