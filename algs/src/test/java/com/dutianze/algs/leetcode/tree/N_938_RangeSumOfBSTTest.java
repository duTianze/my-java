package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/16
 */
class N_938_RangeSumOfBSTTest {

    private final N_938_RangeSumOfBST solution = new N_938_RangeSumOfBST();

    @Test
    void rangeSumBST() {
        TreeNode root = new TreeNode(10, 5, 15, 3, 7, null, 18);

        int result = solution.rangeSumBST(root, 7, 15);

        Assertions.assertEquals(32, result);
    }

    @Test
    void rangeSumBSTRecursion() {
        TreeNode root = new TreeNode(10, 5, 15, 3, 7, null, 18);

        int result = solution.rangeSumBSTRecursion(root, 7, 15);

        Assertions.assertEquals(32, result);
    }
}