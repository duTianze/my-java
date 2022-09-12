package com.dutianze.designpattern.others.twin;

import com.dutianze.designpattern.others.twin.parent.GameItem;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <h2 id="credits">Credits</h2>
 * <ul>
 * <li><a href="http://www.ssw.uni-linz.ac.at/Research/Papers/Moe99/Paper.pdf">Twin – A Design Pattern for Modeling Multiple Inheritance</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/20
 */
@Slf4j
public class BallItem extends GameItem {

  private boolean isSuspended;

  @Setter
  private BallThread twin;

  @Override
  public void doDraw() {
    log.info("doDraw");
  }

  public void move() {
    log.info("move");
  }

  @Override
  public void click() {
    isSuspended = !isSuspended;
    if (isSuspended) {
      twin.suspendMe();
    } else {
      twin.resumeMe();
    }
  }
}