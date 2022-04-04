package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/4/4
 */
class N_1528_ShuffleStringTest {

    private final N_1528_ShuffleString solution = new N_1528_ShuffleString();

    @Test
    void restoreString() {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        String excepted = "leetcode";

        String actual = solution.restoreString(s, indices);

        Assertions.assertEquals(excepted, actual);
    }
}
