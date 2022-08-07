package com.dutianze.designpattern.factorymethod.factory;

import com.dutianze.designpattern.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.factorymethod.weapon.WeaponType;

/**
 * @author dutianze
 * @date 2022/8/7
 */
public interface Blacksmith {

    Weapon manufactureWeapon(WeaponType weaponType);
}
