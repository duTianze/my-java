package com.dutianze.designpattern.structural.flyweight;

import com.dutianze.designpattern.structural.flyweight.potion.Potion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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