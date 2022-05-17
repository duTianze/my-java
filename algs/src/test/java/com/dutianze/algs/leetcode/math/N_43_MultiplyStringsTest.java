package com.dutianze.algs.leetcode.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/17
 */
class N_43_MultiplyStringsTest {

    private final N_43_MultiplyStrings solution = new N_43_MultiplyStrings();

    @Test
    void multiply() {
        String product = solution.multiply("123", "456");
        Assertions.assertEquals("56088", product);
    }
}