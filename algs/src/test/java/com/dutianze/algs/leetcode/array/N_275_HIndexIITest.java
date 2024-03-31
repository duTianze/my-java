package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2024/3/18
 */
class N_275_HIndexIITest {

    private final N_275_HIndexII solution = new N_275_HIndexII();

    @Test
    void hIndex() {
        int[] citations = {0, 1, 3, 5, 6};
        int hIndex = solution.hIndex(citations);
        Assertions.assertEquals(3, hIndex);
    }
}