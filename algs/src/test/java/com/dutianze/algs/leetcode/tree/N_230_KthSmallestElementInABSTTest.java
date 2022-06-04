package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/4
 */
class N_230_KthSmallestElementInABSTTest {

    private final N_230_KthSmallestElementInABST solution = new N_230_KthSmallestElementInABST();

    @Test
    void kthSmallest() {
        TreeNode root = new TreeNode(5, 3, 6, 2, 4, null, null, 1);

        int kthSmallest = solution.kthSmallest(root, 3);

        Assertions.assertEquals(3, kthSmallest);
    }
}