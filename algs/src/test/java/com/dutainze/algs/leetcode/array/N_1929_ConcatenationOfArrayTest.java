package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/3/18
 */
class N_1929_ConcatenationOfArrayTest {

    private final N_1929_ConcatenationOfArray solution = new N_1929_ConcatenationOfArray();

    @Test
    void getConcatenation() {
        int[] nums = {1, 2, 1};
        int[] expected = {1, 2, 1, 1, 2, 1};

        int[] actual = solution.getConcatenation(nums);
        Assertions.assertArrayEquals(expected, actual);
    }
}
