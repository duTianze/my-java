package com.dutianze.algs.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/18
 */
class N_416_PartitionEqualSubsetSumTest {

    private final N_416_PartitionEqualSubsetSum solution = new N_416_PartitionEqualSubsetSum();

    @Test
    void canPartition() {
        boolean canPartition = solution.canPartition(new int[]{1, 5, 11, 5});
        Assertions.assertTrue(canPartition);
    }

    @Test
    void canPartitionCompress() {
        boolean canPartition = solution.canPartitionCompress(new int[]{1, 5, 11, 5});
        Assertions.assertTrue(canPartition);
    }
}