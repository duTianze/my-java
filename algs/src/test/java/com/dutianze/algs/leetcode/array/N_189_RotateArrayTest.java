package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/2/20
 */
class N_189_RotateArrayTest {

    private final N_189_RotateArray solution = new N_189_RotateArray();

    @Test
    void rotate() {
        int[] nums = {1,2,3,4,5,6,7};
        int[] expectedNums = {5,6,7,1,2,3,4};
        int k = 3;

        solution.rotate(nums, k);

        Assertions.assertArrayEquals(expectedNums, nums);
    }

    @Test
    void rotate2() {
        int[] nums = {1,2,3,4,5,6,7};
        int[] expectedNums = {5,6,7,1,2,3,4};
        int k = 3;

        solution.rotate2(nums, k);

        Assertions.assertArrayEquals(expectedNums, nums);
    }
}