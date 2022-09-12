package com.dutianze.designpattern.structural.flyweight;

import com.dutianze.designpattern.structural.flyweight.potion.Potion;
import com.dutianze.designpattern.structural.flyweight.potion.PotionType;
import com.dutianze.designpattern.structural.flyweight.potion.impl.HealingPotion;
import com.dutianze.designpattern.structural.flyweight.potion.impl.HolyWaterPotion;
import com.dutianze.designpattern.structural.flyweight.potion.impl.InvisibilityPotion;
import com.dutianze.designpattern.structural.flyweight.potion.impl.PoisonPotion;
import com.dutianze.designpattern.structural.flyweight.potion.impl.StrengthPotion;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author dutianze
 * @date 2022/8/13
 */
public class PotionFactory {

  private final Map<PotionType, Potion> potions;

  public PotionFactory() {
    potions = new EnumMap<>(PotionType.class);
  }

  Potion createPotion(PotionType type) {
    Potion potion = potions.get(type);
    if (potion == null) {
      synchronized (PotionFactory.class) {
        if (potions.get(type) == null) {
          potion = choosePotion(type);
          potions.put(type, potion);
        }
      }
    }
    return potion;
  }

  private Potion choosePotion(PotionType type) {
    return switch (type) {
      case HEALING -> new HealingPotion();
      case INVISIBILITY -> new HolyWaterPotion();
      case STRENGTH -> new InvisibilityPotion();
      case HOLY_WATER -> new PoisonPotion();
      case POISON -> new StrengthPotion();
    };
  }
}