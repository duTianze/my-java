package com.dutianze.algs.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/5
 */
class N_206_ReverseLinkedListTest {

    private final N_206_ReverseLinkedList solution = new N_206_ReverseLinkedList();

    @Test
    void reverseList() {
        ListNode resource = ListNode.of(new Integer[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.of(new Integer[]{5, 4, 3, 2, 1});

        ListNode result = solution.reverseList(resource);

        Assertions.assertEquals(expected.toString(), result.toString());
    }

    @Test
    void reverseListLoop() {
        ListNode resource = ListNode.of(new Integer[]{1, 2, 3, 4, 5});
        ListNode expected = ListNode.of(new Integer[]{5, 4, 3, 2, 1});

        ListNode result = solution.reverseListLoop(resource);

        Assertions.assertEquals(expected.toString(), result.toString());
    }

    @Test
    void generateListNote() {
        ListNode of = ListNode.of(new Integer[]{1, 2, 3, 4, 5});
        ListNode with = ListNode.with(1, 2, 3, 4, 5);

        Assertions.assertEquals(of.toString(), with.toString());
    }
}