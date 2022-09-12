package com.dutianze.designpattern.creational.factorymethod.weapon;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author dutianze
 * @date 2022/8/7
 */
@ToString
@RequiredArgsConstructor
public enum WeaponType {

  SHORT_SWORD("short sword"),
  SPEAR("spear"),
  AXE("axe"),
  UNDEFINED("");

  private final String title;

}