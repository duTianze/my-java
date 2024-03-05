package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/5
 */
class N_299_BullsAndCowsTest {

    private final N_299_BullsAndCows solution = new N_299_BullsAndCows();

    @Test
    void getHint() {
        String secret = "1123";
        String guess = "0111";
        String output = "1A1B";

        String hint = solution.getHint(secret, guess);

        Assertions.assertEquals(output, hint);
    }
}