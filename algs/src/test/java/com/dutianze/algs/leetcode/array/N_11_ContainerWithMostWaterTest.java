package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/14
 */
class N_11_ContainerWithMostWaterTest {

    private final N_11_ContainerWithMostWater solution = new N_11_ContainerWithMostWater();

    @Test
    void maxArea() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = solution.maxArea(height);

        Assertions.assertEquals(49, maxArea);
    }
}