package com.dutianze.designpattern.behavioral.iterator.list;


import java.util.Iterator;
import java.util.List;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html">java.util.Iterator</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/Enumeration.html">java.util.Enumeration</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/10
 */
public class TreasureChest implements Iterable<Item> {

    private final List<Item> items;
    private ItemType type = ItemType.ANY;

    public TreasureChest(List<Item> items) {
        this.items = items;
    }

    public Iterator<Item> iteratorByType(ItemType type) {
        this.type = type;
        return iterator();
    }

    @Override
    public Iterator<Item> iterator() {
        return new TreasureChestItemIterator();
    }

    private class TreasureChestItemIterator implements Iterator<Item> {

        private int idx = -1;

        @Override
        public boolean hasNext() {
            return findNextIdx() != -1;

        }

        @Override
        public Item next() {
            idx = findNextIdx();
            if (idx != -1) {
                return items.get(idx);
            }
            return null;
        }

        private int findNextIdx() {
            int tempIdx = idx;
            while (true) {
                tempIdx++;
                if (tempIdx >= items.size()) {
                    tempIdx = -1;
                    break;
                }
                if (type.equals(ItemType.ANY) || items.get(tempIdx).getType().equals(type)) {
                    break;
                }
            }
            return tempIdx;
        }
    }
}
