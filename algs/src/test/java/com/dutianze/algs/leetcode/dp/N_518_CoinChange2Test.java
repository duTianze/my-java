package com.dutianze.algs.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/19
 */
class N_518_CoinChange2Test {

    private final N_518_CoinChange2 solution = new N_518_CoinChange2();

    @Test
    void change() {
        int change = solution.change(5, new int[]{1, 2, 5});
        Assertions.assertEquals(4, change);
    }

    @Test
    void changeCompress() {
        int change = solution.changeCompress(5, new int[]{1, 2, 5});
        Assertions.assertEquals(4, change);
    }
}