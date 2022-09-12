package com.dutianze.designpattern.structural.bridge.enchantment;

/**
 * @author dutianze
 * @date 2022/8/12
 */
public interface Enchantment {

  void onActivate();

  void apply();

  void onDeactivate();
}
