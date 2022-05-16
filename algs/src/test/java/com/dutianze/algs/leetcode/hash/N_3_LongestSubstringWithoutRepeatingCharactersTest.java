package com.dutianze.algs.leetcode.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/17
 */
class N_3_LongestSubstringWithoutRepeatingCharactersTest {

    private final N_3_LongestSubstringWithoutRepeatingCharacters solution =
            new N_3_LongestSubstringWithoutRepeatingCharacters();


    @Test
    void lengthOfLongestSubstring() {
        int result = solution.lengthOfLongestSubstring("abba");
        Assertions.assertEquals(2, result);
    }
}