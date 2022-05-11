package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/4/3
 */
class N_771_JewelsAndStonesTest {

    private final N_771_JewelsAndStones solution = new N_771_JewelsAndStones();

    @Test
    void numJewelsInStones() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int expected = 3;

        int result = solution.numJewelsInStones(jewels, stones);

        Assertions.assertEquals(expected, result);
    }
}
