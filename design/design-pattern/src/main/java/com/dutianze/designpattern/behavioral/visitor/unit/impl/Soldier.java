package com.dutianze.designpattern.behavioral.visitor.unit.impl;

import com.dutianze.designpattern.behavioral.visitor.UnitVisitor;
import com.dutianze.designpattern.behavioral.visitor.unit.Unit;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public class Soldier extends Unit {

  public Soldier(Unit... children) {
    super(children);
  }

  @Override
  public void accept(UnitVisitor visitor) {
    visitor.visitSoldier(this);
    super.accept(visitor);
  }

  @Override
  public String toString() {
    return "soldier";
  }
}
