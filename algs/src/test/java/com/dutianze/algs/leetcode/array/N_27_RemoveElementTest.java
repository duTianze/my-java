package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2024/1/24
 */
class N_27_RemoveElementTest {

    private final N_27_RemoveElement solution = new N_27_RemoveElement();

    @Test
    void removeElementTest() {
        // Input array
        int[] nums = {3, 2, 2, 3};
        // Value to remove
        int val = 3;
        // The expected answer with correct length.
        // It is sorted with no values equaling val.
        int[] expectedNums = {2, 2};

        // Calls your implementation
        int k = solution.removeElement(nums, val);
        Assertions.assertEquals(expectedNums.length, k);
        assert k == expectedNums.length;

        // Sort the first k elements of nums
        Arrays.sort(nums, 0, k);
        for (int i = 0; i < expectedNums.length; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }
    }
}