package com.dutianze.designpattern.creational.property;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dutianze.designpattern.creational.property.impl.Character;
import com.dutianze.designpattern.creational.property.impl.Stats;
import com.dutianze.designpattern.creational.property.impl.Type;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/31
 */
@Slf4j
class PrototypeTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      // set up
      Character charProto = new Character();
      charProto.set(Stats.STRENGTH, 10);
      charProto.set(Stats.AGILITY, 10);
      charProto.set(Stats.ARMOR, 10);
      charProto.set(Stats.ATTACK_POWER, 10);

      Character mageProto = new Character(Type.MAGE, charProto);
      mageProto.set(Stats.INTELLECT, 15);
      mageProto.set(Stats.SPIRIT, 10);

      Character warProto = new Character(Type.WARRIOR, charProto);
      warProto.set(Stats.RAGE, 15);
      warProto.set(Stats.ARMOR, 15);

      Character rogueProto = new Character(Type.ROGUE, charProto);
      rogueProto.set(Stats.ENERGY, 15);
      rogueProto.set(Stats.AGILITY, 15);

      // usage
      Character mag = new Character("Player_1", mageProto);
      mag.set(Stats.ARMOR, 8);
      log.info(mag.toString());

      Character warrior = new Character("Player_2", warProto);
      log.info(warrior.toString());

      Character rogue = new Character("Player_3", rogueProto);
      log.info(rogue.toString());

      Character rogueDouble = new Character("Player_4", rogue);
      rogueDouble.set(Stats.ATTACK_POWER, 12);
      log.info(rogueDouble.toString());
    });
  }

  @Test
  void testPrototypeStats() {
    final Character prototype = new Character();

    for (final Stats stat : Stats.values()) {
      assertFalse(prototype.has(stat));
      assertNull(prototype.get(stat));

      final int expectedValue = stat.ordinal();
      prototype.set(stat, expectedValue);
      assertTrue(prototype.has(stat));
      assertEquals(expectedValue, prototype.get(stat));

      prototype.remove(stat);
      assertFalse(prototype.has(stat));
      assertNull(prototype.get(stat));
    }
  }

  @Test
  void testCharacterStats() {
    final Character prototype = new Character();
    Arrays.stream(Stats.values()).forEach(stat -> prototype.set(stat, stat.ordinal()));

    final Character mage = new Character(Type.MAGE, prototype);
    for (final Stats stat : Stats.values()) {
      final int expectedValue = stat.ordinal();
      assertTrue(mage.has(stat));
      assertEquals(expectedValue, mage.get(stat));
    }
  }

  @Test
  void testToString() {
    final Character prototype = new Character();
    prototype.set(Stats.ARMOR, 1);
    prototype.set(Stats.AGILITY, 2);
    prototype.set(Stats.INTELLECT, 3);
    assertEquals("Stats:\n - AGILITY:2\n - ARMOR:1\n - INTELLECT:3\n", prototype.toString());

    final Character stupid = new Character(Type.ROGUE, prototype);
    stupid.remove(Stats.INTELLECT);
    assertEquals("Character type: ROGUE\nStats:\n - AGILITY:2\n - ARMOR:1\n", stupid.toString());

    final Character weak = new Character("weak", prototype);
    weak.remove(Stats.ARMOR);
    assertEquals("Player: weak\nStats:\n - AGILITY:2\n - INTELLECT:3\n", weak.toString());
  }
}