package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/2/6
 */
class N_80_RemoveDuplicatesFromSortedArrayIITest {

    private final N_80_RemoveDuplicatesFromSortedArrayII solution = new N_80_RemoveDuplicatesFromSortedArrayII();

    @Test
    void removeDuplicatesTest() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] expectedNums = {0, 0, 1, 1, 2, 3, 3};

        int k = solution.removeDuplicates(nums);

        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }
    }
}