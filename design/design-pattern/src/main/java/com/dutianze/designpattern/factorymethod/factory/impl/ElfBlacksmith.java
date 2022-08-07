package com.dutianze.designpattern.factorymethod.factory.impl;

import com.dutianze.designpattern.factorymethod.factory.Blacksmith;
import com.dutianze.designpattern.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.factorymethod.weapon.WeaponType;
import com.dutianze.designpattern.factorymethod.weapon.impl.ElfWeapon;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/7
 */
public class ElfBlacksmith implements Blacksmith {

    private static final Map<WeaponType, ElfWeapon> ELFARSENAL;

    static {
        ELFARSENAL = new EnumMap<>(WeaponType.class);
        Arrays.stream(WeaponType.values()).forEach(type -> ELFARSENAL.put(type, new ElfWeapon(type)));
    }

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return ELFARSENAL.get(weaponType);
    }

    @Override
    public String toString() {
        return "The elf blacksmith";
    }
}
