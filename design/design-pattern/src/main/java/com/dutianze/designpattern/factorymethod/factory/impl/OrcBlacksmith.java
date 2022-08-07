package com.dutianze.designpattern.factorymethod.factory.impl;

import com.dutianze.designpattern.factorymethod.factory.Blacksmith;
import com.dutianze.designpattern.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.factorymethod.weapon.WeaponType;
import com.dutianze.designpattern.factorymethod.weapon.impl.OrcWeapon;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/7
 */
public class OrcBlacksmith implements Blacksmith {

    private static final Map<WeaponType, OrcWeapon> ORCARSENAL;

    static {
        ORCARSENAL = new EnumMap<>(WeaponType.class);
        Arrays.stream(WeaponType.values()).forEach(type -> ORCARSENAL.put(type, new OrcWeapon(type)));
    }


    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ORCARSENAL.get(weaponType);
    }

    @Override
    public String toString() {
        return "The orc blacksmith";
    }
}
