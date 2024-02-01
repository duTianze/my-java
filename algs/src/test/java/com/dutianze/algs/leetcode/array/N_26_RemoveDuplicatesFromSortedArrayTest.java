package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/2/1
 */
class N_26_RemoveDuplicatesFromSortedArrayTest {

    private final N_26_RemoveDuplicatesFromSortedArray solution = new N_26_RemoveDuplicatesFromSortedArray();

    @Test
    void removeDuplicates() {
        // Input array
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // The expected answer with correct length
        int[] expectedNums = {0, 1, 2, 3, 4};
        // Calls your implementation
        int k = solution.removeDuplicates(nums);

        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }
    }
}