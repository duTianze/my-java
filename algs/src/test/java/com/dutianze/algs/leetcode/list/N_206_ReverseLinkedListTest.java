package com.dutianze.algs.leetcode.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/5/5
 */
class N_206_ReverseLinkedListTest {

    private final N_206_ReverseLinkedList solution = new N_206_ReverseLinkedList();

    @Test
    void reverseList() {
        Integer[] resource = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(resource);

        ListNode reverseList = solution.reverseList(listNode);

        System.out.println(reverseList);
    }
}