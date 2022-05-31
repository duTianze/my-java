package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/5/31
 */
class N_101_SymmetricTreeTest {

    private final N_101_SymmetricTree solution = new N_101_SymmetricTree();

    @Test
    void isSymmetric() {
        TreeNode root = new TreeNode(1, 2, 2, 3, 4, 4, 3);

        boolean symmetric = solution.isSymmetric(root);

        Assertions.assertTrue(symmetric);
    }
}