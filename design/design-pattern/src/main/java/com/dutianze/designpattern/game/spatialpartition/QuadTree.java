package com.dutianze.designpattern.game.spatialpartition;

import java.util.Collection;
import java.util.Hashtable;

/**
 * @author dutianze
 * @date 2022/8/24
 */
public class QuadTree {

  Rect boundary;
  int capacity;
  boolean divided;
  Hashtable<Integer, Point<Bubble>> points;
  QuadTree northwest;
  QuadTree northeast;
  QuadTree southwest;
  QuadTree southeast;

  QuadTree(Rect boundary, int capacity) {
    this.boundary = boundary;
    this.capacity = capacity;
    this.divided = false;
    this.points = new Hashtable<>();
    this.northwest = null;
    this.northeast = null;
    this.southwest = null;
    this.southeast = null;
  }

  void insert(Point<Bubble> p) {
    if (this.boundary.contains(p)) {
      if (this.points.size() < this.capacity) {
        points.put(p.id, p);
      } else {
        if (!this.divided) {
          this.divide();
        }
        if (this.northwest.boundary.contains(p)) {
          this.northwest.insert(p);
        } else if (this.northeast.boundary.contains(p)) {
          this.northeast.insert(p);
        } else if (this.southwest.boundary.contains(p)) {
          this.southwest.insert(p);
        } else if (this.southeast.boundary.contains(p)) {
          this.southeast.insert(p);
        }
      }
    }
  }

  void divide() {
    double x = this.boundary.coordinateX;
    double y = this.boundary.coordinateY;
    double width = this.boundary.width;
    double height = this.boundary.height;
    Rect nw = new Rect(x - width / 4, y + height / 4, width / 2, height / 2);
    this.northwest = new QuadTree(nw, this.capacity);
    Rect ne = new Rect(x + width / 4, y + height / 4, width / 2, height / 2);
    this.northeast = new QuadTree(ne, this.capacity);
    Rect sw = new Rect(x - width / 4, y - height / 4, width / 2, height / 2);
    this.southwest = new QuadTree(sw, this.capacity);
    Rect se = new Rect(x + width / 4, y - height / 4, width / 2, height / 2);
    this.southeast = new QuadTree(se, this.capacity);
    this.divided = true;
  }

  Collection<Point<Bubble>> query(Rect r, Collection<Point<Bubble>> relevantPoints) {
    //could also be a circle instead of a rectangle
    if (this.boundary.intersects(r)) {
      this.points
          .values()
          .stream()
          .filter(r::contains)
          .forEach(relevantPoints::add);
      if (this.divided) {
        this.northwest.query(r, relevantPoints);
        this.northeast.query(r, relevantPoints);
        this.southwest.query(r, relevantPoints);
        this.southeast.query(r, relevantPoints);
      }
    }
    return relevantPoints;
  }
}
