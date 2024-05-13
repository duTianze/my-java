package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/5/13
 */
class N_316_RemoveDuplicateLettersTest {

    private final N_316_RemoveDuplicateLetters solution = new N_316_RemoveDuplicateLetters();

    @Test
    void removeDuplicateLetters() {
        String result1 = solution.removeDuplicateLetters("bcabc");
        Assertions.assertEquals("abc", result1);

        String result2 = solution.removeDuplicateLetters("cbacdcbc");
        Assertions.assertEquals("acdb", result2);
    }
}