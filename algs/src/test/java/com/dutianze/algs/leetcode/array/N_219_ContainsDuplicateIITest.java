package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/31
 */
class N_219_ContainsDuplicateIITest {

    private final N_219_ContainsDuplicateII solution = new N_219_ContainsDuplicateII();

    @Test
    void containsNearbyDuplicate() {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean result = solution.containsNearbyDuplicate(nums, k);
        Assertions.assertFalse(result);
    }

    @Test
    void containsNearbyDuplicate2() {
        int[] nums = {1,2,1};
        int k = 0;
        boolean result = solution.containsNearbyDuplicate2(nums, k);
        Assertions.assertFalse(result);
    }
}