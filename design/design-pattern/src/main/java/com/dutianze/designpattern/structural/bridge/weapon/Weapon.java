package com.dutianze.designpattern.structural.bridge.weapon;

import com.dutianze.designpattern.structural.bridge.enchantment.Enchantment;

/**
 * @author dutianze
 * @date 2022/8/12
 */
public interface Weapon {

    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}
