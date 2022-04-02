package com.dutainze.algs.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/4/2
 */
class N_1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

    private final N_1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers solution =
            new N_1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers();

    @Test
    void minPartitions() {
        String n = "32";
        int expected = 3;

        int result = solution.minPartitions(n);

        Assertions.assertEquals(expected, result);
    }
}
