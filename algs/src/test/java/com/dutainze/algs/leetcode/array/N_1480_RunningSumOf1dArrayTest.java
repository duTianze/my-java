package com.dutainze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/3/18
 */
class N_1480_RunningSumOf1dArrayTest {

    private final N_1480_RunningSumOf1dArray solution = new N_1480_RunningSumOf1dArray();

    @Test
    void runningSum() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {1, 3, 6, 10};

        int[] actual = solution.runningSum(nums);
        Assertions.assertArrayEquals(expected, actual);
    }
}
