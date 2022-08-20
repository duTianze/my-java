package com.dutianze.designpattern.others.twin.parent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/20
 */
@Slf4j
public abstract class GameItem {

    public void draw() {
        log.info("draw");
        doDraw();
    }

    public abstract void doDraw();


    public abstract void click();
}