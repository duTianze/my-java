package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/3/29
 */
class N_1828_QueriesOnNumberOfPointsInsideACircleTest {

    private final N_1828_QueriesOnNumberOfPointsInsideACircle solution =
            new N_1828_QueriesOnNumberOfPointsInsideACircle();

    @Test
    void countPoints() {
        int[][] points = {{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] expected = {3, 2, 2};

        int[] actual = solution.countPoints(points, queries);
        Assertions.assertArrayEquals(expected, actual);
    }
}
