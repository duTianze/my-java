package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/31
 */
class N_220_ContainsDuplicateIIITest {

    private final N_220_ContainsDuplicateIII solution = new N_220_ContainsDuplicateIII();

    /**
     * Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
     * Output: false
     * Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
     */
    @Test
    void containsNearbyAlmostDuplicate() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int indexDiff = 2;
        int valueDiff = 3;

        boolean result = solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff);
        Assertions.assertFalse(result);
    }

    @Test
    void containsNearbyAlmostDuplicate2() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int indexDiff = 2;
        int valueDiff = 3;

        boolean result = solution.containsNearbyAlmostDuplicate2(nums, indexDiff, valueDiff);
        Assertions.assertFalse(result);
    }
}