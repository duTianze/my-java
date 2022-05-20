package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/20
 */
class N_452_MinimumNumberOfArrowsToBurstBalloonsTest {

    private final N_452_MinimumNumberOfArrowsToBurstBalloons solution =
            new N_452_MinimumNumberOfArrowsToBurstBalloons();

    @Test
    void findMinArrowShots() {
        int minArrowShots = solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        Assertions.assertEquals(2, minArrowShots);
    }
}