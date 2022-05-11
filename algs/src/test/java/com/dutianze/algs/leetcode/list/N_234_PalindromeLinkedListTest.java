package com.dutianze.algs.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/11
 */
class N_234_PalindromeLinkedListTest {

    private final N_234_PalindromeLinkedList solution = new N_234_PalindromeLinkedList();

    @Test
    void isPalindrome() {
        ListNode resource = ListNode.with(new Integer[]{1, 2, 2, 1});

        boolean result = solution.isPalindrome(resource);

        Assertions.assertTrue(result);
    }
}