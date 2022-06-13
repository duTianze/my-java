package com.dutianze.algs.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/11
 */
class N_92_ReverseLinkedListIITest {

    private final N_92_ReverseLinkedListII solution = new N_92_ReverseLinkedListII();

    @Test
    void reverseBetween() {
        ListNode resource = ListNode.with(1, 2, 3, 4, 5);
        int left = 2, right = 4;
        ListNode expected = ListNode.with(1, 4, 3, 2, 5);

        ListNode result = solution.reverseBetween(resource, left, right);

        Assertions.assertEquals(expected.toString(), result.toString());
    }

    @Test
    void reverseBetweenLoop() {
        ListNode resource = ListNode.with(1, 2, 3, 4, 5);
        int left = 2, right = 4;
        ListNode expected = ListNode.with(1, 4, 3, 2, 5);

        ListNode result = solution.reverseBetweenLoop(resource, left, right);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
}