package com.dutianze.designpattern.creational.factorymethod.weapon.impl;

import com.dutianze.designpattern.creational.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.creational.factorymethod.weapon.WeaponType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author dutianze
 * @date 2022/8/7
 */
@RequiredArgsConstructor
@Getter
public class OrcWeapon implements Weapon {

  private final WeaponType weaponType;

  @Override
  public String toString() {
    return "an orcish " + weaponType;
  }
}
