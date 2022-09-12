package com.dutianze.designpattern.game.subclasssandbox.impl;

import com.dutianze.designpattern.game.subclasssandbox.Superpower;

/**
 * @author dutianze
 * @date 2022/8/23
 */
public class GroundDive extends Superpower {

  @Override
  protected void activate() {
    move(0, 0, -20);
    playSound("GROUNDDIVE_SOUND", 5);
    spawnParticles("GROUNDDIVE_PARTICLE", 20);
  }
}
