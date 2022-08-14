package com.dutianze.designpattern.behavioral.templatemethod.stealing;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public abstract class StealingMethod {

    protected abstract String pickTarget();

    protected abstract void confuseTarget(String target);

    protected abstract void stealTheItem(String target);

    public void steal() {
        String target = pickTarget();
        log.info("The target has been chosen as {}.", target);
        confuseTarget(target);
        stealTheItem(target);
    }
}
