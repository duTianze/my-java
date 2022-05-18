package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/18
 */
class N_55_JumpGameTest {

    private final N_55_JumpGame solution = new N_55_JumpGame();

    @Test
    void canJump() {
        boolean canJump = solution.canJump(new int[]{2, 3, 1, 1, 4});
        Assertions.assertTrue(canJump);
    }
}