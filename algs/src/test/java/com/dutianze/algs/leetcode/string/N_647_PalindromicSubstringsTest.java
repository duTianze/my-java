package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/15
 */
class N_647_PalindromicSubstringsTest {

    private final N_647_PalindromicSubstrings solution = new N_647_PalindromicSubstrings();

    @Test
    void countSubstrings() {
        int result = solution.countSubstrings("aaa");

        Assertions.assertEquals(6, result);
    }
}