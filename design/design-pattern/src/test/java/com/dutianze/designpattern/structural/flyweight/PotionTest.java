package com.dutianze.designpattern.structural.flyweight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.dutianze.designpattern.structural.flyweight.potion.Potion;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/13
 */
class PotionTest {

  @Test
  void testShop() {
    final AlchemistShop shop = new AlchemistShop();

    final List<Potion> shelf = shop.getShelf();
    assertNotNull(shelf);
    assertEquals(13, shelf.size());
    assertEquals(5, shelf.stream().map(System::identityHashCode).distinct().count());
  }
}