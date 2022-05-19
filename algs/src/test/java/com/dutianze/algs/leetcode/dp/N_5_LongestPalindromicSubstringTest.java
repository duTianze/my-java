package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/19
 */
class N_5_LongestPalindromicSubstringTest {

    private final N_5_LongestPalindromicSubstring solution = new N_5_LongestPalindromicSubstring();

    @Test
    void longestPalindrome() {
        String longestPalindrome = solution.longestPalindrome("cbbd");
        Assertions.assertEquals("bb", longestPalindrome);
    }
}