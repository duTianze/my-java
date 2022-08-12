package com.dutianze.designpattern.iterator.list;

import com.dutianze.designpattern.behavioral.iterator.list.Item;
import com.dutianze.designpattern.behavioral.iterator.list.ItemType;
import com.dutianze.designpattern.behavioral.iterator.list.TreasureChest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/10
 */
class TreasureChestTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testIterator(Item expectedItem) {
        final TreasureChest chest = new TreasureChest(initData());
        Iterator<Item> iterator = chest.iteratorByType(expectedItem.getType());
        assertNotNull(iterator);

        while (iterator.hasNext()) {
            final Item item = iterator.next();
            assertNotNull(item);
            assertEquals(expectedItem.getType(), item.getType());

            final String name = item.toString();
            assertNotNull(name);
            if (expectedItem.toString().equals(name)) {
                return;
            }
        }

        fail("Expected to find item [" + expectedItem + "] using iterator, but we didn't.");
    }

    public static List<Object[]> dataProvider() {
        return List.of(
                new Object[]{new Item(ItemType.POTION, "Potion of courage")},
                new Object[]{new Item(ItemType.RING, "Ring of shadows")},
                new Object[]{new Item(ItemType.POTION, "Potion of wisdom")},
                new Object[]{new Item(ItemType.POTION, "Potion of blood")},
                new Object[]{new Item(ItemType.WEAPON, "Sword of silver +1")},
                new Object[]{new Item(ItemType.POTION, "Potion of rust")},
                new Object[]{new Item(ItemType.POTION, "Potion of healing")},
                new Object[]{new Item(ItemType.RING, "Ring of armor")},
                new Object[]{new Item(ItemType.WEAPON, "Steel halberd")},
                new Object[]{new Item(ItemType.WEAPON, "Dagger of poison")}
        );
    }

    private static List<Item> initData() {
        return List.of(
                new Item(ItemType.POTION, "Potion of courage"),
                new Item(ItemType.RING, "Ring of shadows"),
                new Item(ItemType.POTION, "Potion of wisdom"),
                new Item(ItemType.POTION, "Potion of blood"),
                new Item(ItemType.WEAPON, "Sword of silver +1"),
                new Item(ItemType.POTION, "Potion of rust"),
                new Item(ItemType.POTION, "Potion of healing"),
                new Item(ItemType.RING, "Ring of armor"),
                new Item(ItemType.WEAPON, "Steel halberd"),
                new Item(ItemType.WEAPON, "Dagger of poison"));
    }

}