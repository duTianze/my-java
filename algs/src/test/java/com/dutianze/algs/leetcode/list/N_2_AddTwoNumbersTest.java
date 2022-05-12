package com.dutianze.algs.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/12
 */
class N_2_AddTwoNumbersTest {

    private final N_2_AddTwoNumbers solution = new N_2_AddTwoNumbers();

    @Test
    void addTwoNumbers() {
        ListNode l1 = ListNode.with(new Integer[]{2, 4, 3});
        ListNode l2 = ListNode.with(new Integer[]{5, 6, 4});
        ListNode expected = ListNode.with(new Integer[]{7, 0, 8});

        ListNode result = solution.addTwoNumbers(l1, l2);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
}