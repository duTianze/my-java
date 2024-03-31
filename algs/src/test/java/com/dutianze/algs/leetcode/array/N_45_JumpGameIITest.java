package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/20
 */
class N_45_JumpGameIITest {

    private final N_45_JumpGameII solution = new N_45_JumpGameII();

    @Test
    void jump() {
        int jump = solution.jump(new int[]{2, 3, 1, 1, 4});
        Assertions.assertEquals(2, jump);
    }
}