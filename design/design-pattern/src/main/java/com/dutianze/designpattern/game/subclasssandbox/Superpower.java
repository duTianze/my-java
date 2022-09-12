package com.dutianze.designpattern.game.subclasssandbox;

import lombok.extern.slf4j.Slf4j;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="https://gameprogrammingpatterns.com/subclass-sandbox.html">Game Programming Patterns - Subclass Sandbox</a></li>
 * </ul>
 * <h2 id="credits">See Also</h2>
 * 1. update-method 通常也是沙箱方法
 * <p>
 * 2. 与 template-method 正相反
 *      template-method:  子类实现具体的操作，父类组织操作
 *      subclass-sandbox: 父类包含具体的操作，子类组织操作
 * <p>
 * 3. 可认为是 facade 模式的变形，父类扮演 facade 隐藏了游戏引擎
 *
 * @author dutianze
 * @date 2022/8/23
 */
@Slf4j
public abstract class Superpower {

  protected abstract void activate();

  protected void move(double x, double y, double z) {
    log.info("Move to ( " + x + ", " + y + ", " + z + " )");
  }

  protected void playSound(String soundName, int volumn) {
    log.info("Play " + soundName + " with volumn " + volumn);
  }

  protected void spawnParticles(String particleType, int count) {
    log.info("Spawn " + count + " particle with type " + particleType);
  }
}
