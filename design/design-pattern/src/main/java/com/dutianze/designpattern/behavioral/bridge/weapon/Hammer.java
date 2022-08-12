package com.dutianze.designpattern.behavioral.bridge.weapon;

import com.dutianze.designpattern.behavioral.bridge.enchantment.Enchantment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/12
 */
@Slf4j
@AllArgsConstructor
public class Hammer implements Weapon {

    private final Enchantment enchantment;

    @Override
    public void wield() {
        log.info("The hammer is wielded.");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        log.info("The hammer is swung.");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        log.info("The hammer is unwielded.");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}