package com.dutianze.designpattern.game.spatialpartition;

import java.util.Collection;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public abstract class Point<T> {

  public int coordinateX;
  public int coordinateY;
  public final int id;

  Point(int x, int y, int id) {
    this.coordinateX = x;
    this.coordinateY = y;
    this.id = id;
  }

  abstract void move();

  abstract boolean touches(T obj);

  abstract void handleCollision(Collection<? extends Point<T>> toCheck, Map<Integer, T> all);
}
