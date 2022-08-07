package com.dutianze.designpattern.factorymethod.weapon.impl;

import com.dutianze.designpattern.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.factorymethod.weapon.WeaponType;
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
