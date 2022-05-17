package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/17
 */
class N_167_TwoSumIIInputArrayIsSortedTest {

    private final N_167_TwoSumIIInputArrayIsSorted solution = new N_167_TwoSumIIInputArrayIsSorted();

    @Test
    void twoSum() {
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assertions.assertArrayEquals(new int[]{1, 2}, result);
    }
}