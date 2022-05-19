package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/19
 */
class N_72_EditDistanceTest {

    private final N_72_EditDistance solution = new N_72_EditDistance();

    @Test
    void minDistance() {
        int minDistance = solution.minDistance("horse", "ros");
        Assertions.assertEquals(3, minDistance);
    }
}