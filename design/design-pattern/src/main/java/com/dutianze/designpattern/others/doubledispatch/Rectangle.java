package com.dutianze.designpattern.others.doubledispatch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <h2 id="real-world-examples">Real world examples</h2>
 * <ul>
 * <li><a href="https://docs.oracle.com/javase/8/docs/api/java/io/ObjectOutputStream.html">ObjectOutputStream</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/9/14
 */
@Getter
@RequiredArgsConstructor
public class Rectangle {

  private final int left;
  private final int top;
  private final int right;
  private final int bottom;

  public boolean intersectsWith(Rectangle r) {
    return !(r.getLeft() > getRight() || r.getRight() < getLeft() || r.getTop() > getBottom() || r
        .getBottom() < getTop());
  }

  @Override
  public String toString() {
    return String.format("[%d,%d,%d,%d]", getLeft(), getTop(), getRight(), getBottom());
  }
}
