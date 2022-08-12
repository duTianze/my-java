package com.dutianze.designpattern.creational.factorymethod;

import com.dutianze.designpattern.creational.factorymethod.factory.impl.ElfBlacksmith;
import com.dutianze.designpattern.creational.factorymethod.factory.impl.OrcBlacksmith;
import com.dutianze.designpattern.creational.factorymethod.weapon.Weapon;
import com.dutianze.designpattern.creational.factorymethod.weapon.WeaponType;
import com.dutianze.designpattern.creational.factorymethod.weapon.impl.ElfWeapon;
import com.dutianze.designpattern.creational.factorymethod.weapon.impl.OrcWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dutianze
 * @date 2022/8/7
 */
class OrcBlacksmithTest {

    @Test
    void orcBlacksmithWithSpear() {
        OrcBlacksmith blacksmith = new OrcBlacksmith();
        Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        verifyWeapon(weapon, WeaponType.SPEAR, OrcWeapon.class);
    }

    @Test
    void testElfBlacksmithWithShortSword() {
        ElfBlacksmith blacksmith = new ElfBlacksmith();
        Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
        verifyWeapon(weapon, WeaponType.SHORT_SWORD, ElfWeapon.class);
    }


    private void verifyWeapon(Weapon weapon, WeaponType expectedWeaponType, Class<?> clazz) {
        assertTrue(clazz.isInstance(weapon), "Weapon must be an object of: " + clazz.getName());
        assertEquals(expectedWeaponType, weapon
                .getWeaponType(), "Weapon must be of weaponType: " + expectedWeaponType);
    }
}