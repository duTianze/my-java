package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/31
 */
class N_217_ContainsDuplicateTest {

    private final N_217_ContainsDuplicate solution = new N_217_ContainsDuplicate();

    @Test
    void containsDuplicate() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean result = solution.containsDuplicate(nums);

        Assertions.assertTrue(result);
    }
}