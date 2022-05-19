package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/19
 */
class N_435_NonOverlappingIntervalsTest {

    private final N_435_NonOverlappingIntervals solution = new N_435_NonOverlappingIntervals();

    @Test
    void eraseOverlapIntervals() {
        int result = solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        Assertions.assertEquals(1, result);
    }
}