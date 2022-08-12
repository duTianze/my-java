package com.dutianze.designpattern.behavioral.bridge.weapon;

import com.dutianze.designpattern.behavioral.bridge.enchantment.Enchantment;

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
