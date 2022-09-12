package com.dutianze.designpattern.game.spatialpartition;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class Rect {

  double coordinateX;
  double coordinateY;
  double width;
  double height;

  //(x,y) - centre of rectangle

  Rect(double x, double y, double width, double height) {
    this.coordinateX = x;
    this.coordinateY = y;
    this.width = width;
    this.height = height;
  }

  boolean contains(Point<Bubble> p) {
    return p.coordinateX >= this.coordinateX - this.width / 2
        && p.coordinateX <= this.coordinateX + this.width / 2
        && p.coordinateY >= this.coordinateY - this.height / 2
        && p.coordinateY <= this.coordinateY + this.height / 2;
  }

  boolean intersects(Rect other) {
    return !(this.coordinateX + this.width / 2 <= other.coordinateX - other.width / 2
        || this.coordinateX - this.width / 2 >= other.coordinateX + other.width / 2
        || this.coordinateY + this.height / 2 <= other.coordinateY - other.height / 2
        || this.coordinateY - this.height / 2 >= other.coordinateY + other.height / 2);
  }
}
