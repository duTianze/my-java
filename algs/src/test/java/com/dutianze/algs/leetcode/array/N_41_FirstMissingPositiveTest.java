package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/2/27
 */
class N_41_FirstMissingPositiveTest {

    private final N_41_FirstMissingPositive solution = new N_41_FirstMissingPositive();

    @Test
    void firstMissingPositive() {
        int[] nums = {7,8,9,11,12};
        int output = solution.firstMissingPositive(nums);
        Assertions.assertEquals(1, output);
    }

    @Test
    void firstMissingPositive2() {
        int[] nums = {7,8,9,11,12};
        int output = solution.firstMissingPositive2(nums);
        Assertions.assertEquals(1, output);
    }
}