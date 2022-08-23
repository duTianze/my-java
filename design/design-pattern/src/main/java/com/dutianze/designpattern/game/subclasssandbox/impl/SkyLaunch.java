package com.dutianze.designpattern.game.subclasssandbox.impl;

import com.dutianze.designpattern.game.subclasssandbox.Superpower;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/23
 */
@Slf4j
public class SkyLaunch extends Superpower {

    @Override
    protected void activate() {
        move(1, 1, 20);
        playSound("SKYLAUNCH_SOUND", 1);
        spawnParticles("SKYLAUNCH_PARTICLE", 100);
    }
}
