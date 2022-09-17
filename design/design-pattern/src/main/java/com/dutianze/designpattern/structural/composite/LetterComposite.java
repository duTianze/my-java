package com.dutianze.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 大部分国家的军队都采用层次结构管理。 每支部队包括几个师， 师由旅构成， 旅由团构成， 团可以继续划分为排。
 * <p>
 * 最后， 每个排由一小队实实在在的士兵组成。
 * <p>
 * 军事命令由最高层下达， 通过每个层级传递， 直到每位士兵都知道自己应该服从的命令。
 * <p>
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/awt/Container.html">java.awt.Container</a> and <a href="http://docs.oracle.com/javase/8/docs/api/java/awt/Component.html">java.awt.Component</a></li>
 * <li><a href="https://github.com/apache/wicket">Apache Wicket</a> component tree, see <a href="https://github.com/apache/wicket/blob/91e154702ab1ff3481ef6cbb04c6044814b7e130/wicket-core/src/main/java/org/apache/wicket/Component.java">Component</a> and <a href="https://github.com/apache/wicket/blob/b60ec64d0b50a611a9549809c9ab216f0ffa3ae3/wicket-core/src/main/java/org/apache/wicket/MarkupContainer.java">MarkupContainer</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/12
 */
public abstract class LetterComposite {

  private final List<LetterComposite> children = new ArrayList<>();

  public void add(LetterComposite letter) {
    children.add(letter);
  }

  public int count() {
    return children.size();
  }

  public void print() {
    printThisBefore();
    children.forEach(LetterComposite::print);
    printThisAfter();
  }

  protected void printThisBefore() {
  }

  protected void printThisAfter() {
  }
}
