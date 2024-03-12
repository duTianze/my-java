package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/12
 */
class N_169_MajorityElementTest {

    private final N_169_MajorityElement solution = new N_169_MajorityElement();

    @Test
    void majorityElement() {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int num = solution.majorityElement(nums);
        Assertions.assertEquals(2, num);
    }
}