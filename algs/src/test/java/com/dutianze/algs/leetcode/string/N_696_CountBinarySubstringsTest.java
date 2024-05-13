package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/5/13
 */
class N_696_CountBinarySubstringsTest {

    private final N_696_CountBinarySubstrings solution = new N_696_CountBinarySubstrings();

    /**
     * There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
     * Notice that some of these substrings repeat and are counted the number of times they occur.
     * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
     */
    @Test
    void countBinarySubstrings() {
        int count = solution.countBinarySubstrings("00110011");
        Assertions.assertEquals(6, count);
    }

    /**
     * There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
     */
    @Test
    void countBinarySubstrings2() {
        int count = solution.countBinarySubstrings("10101");
        Assertions.assertEquals(4, count);
    }
}