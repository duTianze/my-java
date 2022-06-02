package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/2
 */
class N_112_PathSumTest {

    private final N_112_PathSum solution = new N_112_PathSum();

    @Test
    void hasPathSum() {
        TreeNode root = new TreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);

        boolean hasPathSum = solution.hasPathSum(root, 22);

        Assertions.assertTrue(hasPathSum);
    }
}