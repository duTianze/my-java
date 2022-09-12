package com.dutianze.designpattern.creational.builder.valueobject;

/**
 * @author dutianze
 * @date 2022/8/7
 */
public enum Weapon {

  DAGGER, SWORD, AXE, WARHAMMER, BOW;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
