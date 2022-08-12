package com.dutianze.designpattern.behavioral.bridge;

import com.dutianze.designpattern.behavioral.bridge.enchantment.Enchantment;
import com.dutianze.designpattern.behavioral.bridge.enchantment.FlyingEnchantment;
import com.dutianze.designpattern.behavioral.bridge.weapon.Hammer;
import com.dutianze.designpattern.behavioral.bridge.weapon.Sword;
import com.dutianze.designpattern.behavioral.bridge.weapon.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/12
 */
class WeaponTest {

    @Test
    void testHammer() {
        final Hammer hammer = spy(new Hammer(mock(FlyingEnchantment.class)));
        testBasicWeaponActions(hammer);
    }

    @Test
    void testSword() {
        final Sword sword = spy(new Sword(mock(FlyingEnchantment.class)));
        testBasicWeaponActions(sword);
    }

    final void testBasicWeaponActions(final Weapon weapon) {
        assertNotNull(weapon);
        Enchantment enchantment = weapon.getEnchantment();
        assertNotNull(enchantment);
        assertNotNull(weapon.getEnchantment());

        weapon.swing();
        verify(enchantment).apply();
        verifyNoMoreInteractions(enchantment);

        weapon.wield();
        verify(enchantment).onActivate();
        verifyNoMoreInteractions(enchantment);

        weapon.unwield();
        verify(enchantment).onDeactivate();
        verifyNoMoreInteractions(enchantment);

    }
}