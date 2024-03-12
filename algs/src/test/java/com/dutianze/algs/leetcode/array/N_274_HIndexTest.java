package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/12
 */
class N_274_HIndexTest {

    private final N_274_HIndex solution = new N_274_HIndex();

    @Test
    void hIndex() {
        int[] citations = {3, 0, 6, 1, 5};
        int hIndex = solution.hIndex(citations);
        int hIndex2 = solution.hIndex2(citations);
        Assertions.assertEquals(3, hIndex);
        Assertions.assertEquals(3, hIndex2);
    }
}