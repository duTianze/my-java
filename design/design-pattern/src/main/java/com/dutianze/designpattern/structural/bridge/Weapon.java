package com.dutianze.designpattern.structural.bridge;

import com.dutianze.designpattern.structural.bridge.enchantment.Enchantment;

/**
 * 桥接模式是一个更推荐组合而不是继承的模式。将实现细节从一个层次结构推送到具有单独层次结构的另一个对象。
 *
 * @author dutianze
 * @date 2022/8/12
 */
public interface Weapon {

  void wield();

  void swing();

  void unwield();

  Enchantment getEnchantment();
}
