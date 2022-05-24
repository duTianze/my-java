package com.dutianze.algs.leetcode.hash;

import java.util.HashMap;

/**
 * @author dutianze
 * @date 2022/5/23
 */
public class N_146_LRU_Cache_DoubleList {

    // key -> Node(key, val)
    private final HashMap<Integer, Node> map;
    //Node(k1, v1) <-> Node(k2, v2)...
    private final DoubleList cache;
    private final int cap;

    public N_146_LRU_Cache_DoubleList(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        this.makeRecently(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if (node != null) {
            // 删除旧的数据
            cache.remove(node);
            map.remove(node.key);
            // 新插入的数据为最近使用的数据
            addRecently(key, val);
            return;
        }

        if (cap == cache.size()) {
            // 删除最久未使用的元素
            removeLeastRecently();
        }
        // 添加为最近使用的元素
        addRecently(key, val);
    }

    /**
     * 将某个 key 提升为最近使用的
     */
    private void makeRecently(Node node) {
        // 先从链表中删除这个节点
        cache.remove(node);
        // 重新插到队尾
        cache.addLast(node);
    }

    /**
     * 添加最近使用的元素
     */
    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        // 链表尾部就是最近使用的元素
        cache.addLast(x);
        // 别忘了在 map 中添加 key 的映射
        map.put(key, x);
    }

    /**
     * 删除最久未使用的元素
     */
    private void removeLeastRecently() {
        // 链表头部的第一个元素就是最久未使用的
        Node deletedNode = cache.removeFirst();
        // 同时别忘了从 map 中删除它的 key
        int deletedKey = deletedNode.key;
        map.remove(deletedKey);
    }

    private static class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public static class DoubleList {
        private final Node head;
        private final Node tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 在链表尾部添加节点 x，时间 O(1)
         */
        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        /**
         * 删除链表中的 x 节点（x 一定存在）
         * 由于是双链表且给的是目标 Node 节点，时间 O(1)
         */
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        /**
         * 删除链表中第一个节点，并返回该节点，时间 O(1)
         */
        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        /**
         * 返回链表长度，时间 O(1)
         */
        public int size() {return size;}
    }
}
