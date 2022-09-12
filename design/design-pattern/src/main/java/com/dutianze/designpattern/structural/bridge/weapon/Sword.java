package com.dutianze.designpattern.structural.bridge.weapon;

import com.dutianze.designpattern.structural.bridge.Weapon;
import com.dutianze.designpattern.structural.bridge.enchantment.Enchantment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/12
 */
@Slf4j
@AllArgsConstructor
public class Sword implements Weapon {

  private final Enchantment enchantment;

  @Override
  public void wield() {
    log.info("The sword is wielded.");
    enchantment.onActivate();
  }

  @Override
  public void swing() {
    log.info("The sword is swung.");
    enchantment.apply();
  }

  @Override
  public void unwield() {
    log.info("The sword is unwielded.");
    enchantment.onDeactivate();
  }

  @Override
  public Enchantment getEnchantment() {
    return enchantment;
  }
}
