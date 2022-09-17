package com.dutianze.designpattern.behavioral.command;

import java.util.Deque;
import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;

/**
 * 在市中心逛了很久的街后， 你找到了一家不错的餐厅， 坐在了临窗的座位上。
 * <p>
 * 一名友善的服务员走近你， 迅速记下你点的食物， 写在一张纸上。 服务员来到厨房， 把订单贴在墙上。
 * <p>
 * 过了一段时间，厨师拿到了订单， 他根据订单来准备食物。 厨师将做好的食物和订单一起放在托盘上。
 * <p>
 * 服务员看到托盘后对订单进行检查， 确保所有食物都是你要的， 然后将食物放到了你的桌上。
 * <p><p>
 * 那张纸就是一个命令， 它在厨师开始烹饪前一直位于队列中。 命令中包含与烹饪这些食物相关的所有信息。
 * <p>
 * 厨师能够根据它马上开始烹饪， 而无需跑来直接和你确认订单详情。
 * <p>
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html">java.lang.Runnable</a></li>
 * <li><a href="https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/runners/model/Statement.java">org.junit.runners.model.Statement</a></li>
 * <li><a href="https://github.com/Netflix/Hystrix/wiki">Netflix Hystrix</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/javax/swing/Action.html">javax.swing.Action</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/13
 */
@Slf4j
public class Wizard {

  private final Deque<Runnable> undoStack = new LinkedList<>();
  private final Deque<Runnable> redoStack = new LinkedList<>();

  public void castSpell(Runnable runnable) {
    runnable.run();
    undoStack.offerLast(runnable);
  }

  public void undoLastSpell() {
    if (!undoStack.isEmpty()) {
      Runnable previousSpell = undoStack.pollLast();
      redoStack.offerLast(previousSpell);
      previousSpell.run();
    }
  }

  public void redoLastSpell() {
    if (!redoStack.isEmpty()) {
      Runnable previousSpell = redoStack.pollLast();
      undoStack.offerLast(previousSpell);
      previousSpell.run();
    }
  }

  @Override
  public String toString() {
    return "Wizard";
  }
}