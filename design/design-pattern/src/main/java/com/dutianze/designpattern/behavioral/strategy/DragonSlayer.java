package com.dutianze.designpattern.behavioral.strategy;

import com.dutianze.designpattern.behavioral.strategy.strategy.DragonSlayingStrategy;

/**
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#compare"><code>java.util.Comparator#compare()</code></a>, executed by among others <code>Collections#sort()</code>.</li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 * @see java.util.Comparator#compare(Object, Object)
 */
public class DragonSlayer {

  private DragonSlayingStrategy strategy;

  public DragonSlayer(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void changeStrategy(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void goToBattle() {
    strategy.execute();
  }
}