package com.dutianze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/22
 */
class N_1221_SplitAStringInBalancedStringsTest {

    private final N_1221_SplitAStringInBalancedStrings solution = new N_1221_SplitAStringInBalancedStrings();

    @Test
    void balancedStringSplit() {
        int balancedStringSplit = solution.balancedStringSplit("RLRRLLRLRL");
        Assertions.assertEquals(4, balancedStringSplit);
    }
}