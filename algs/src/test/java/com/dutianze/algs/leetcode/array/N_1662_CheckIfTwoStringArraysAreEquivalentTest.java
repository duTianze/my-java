package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/21
 */
class N_1662_CheckIfTwoStringArraysAreEquivalentTest {

    private final N_1662_CheckIfTwoStringArraysAreEquivalent solution = new N_1662_CheckIfTwoStringArraysAreEquivalent();

    @Test
    void arrayStringsAreEqual() {
        boolean arrayStringsAreEqual = solution.arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"});
        Assertions.assertFalse(arrayStringsAreEqual);
    }

    @Test
    void arrayStringsAreEqual2() {
        boolean arrayStringsAreEqual = solution.arrayStringsAreEqual2(new String[]{"a", "cb"}, new String[]{"ab", "c"});
        Assertions.assertFalse(arrayStringsAreEqual);
    }
}