package com.dutianze.designpattern.game.updatemethod.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/18
 */
@Slf4j
public class Statue extends Entity {

  @Setter
  @Getter
  protected int frames;

  protected int delay;

  public Statue(int id) {
    super(id);
    this.frames = 0;
    this.delay = 0;
  }

  public Statue(int id, int delay) {
    super(id);
    this.frames = 0;
    this.delay = delay;
  }

  @Override
  public void update() {
    if (++frames == delay) {
      shootLightning();
      frames = 0;
    }
  }

  private void shootLightning() {
    log.info("Statue " + id + " shoots lightning!");
  }
}