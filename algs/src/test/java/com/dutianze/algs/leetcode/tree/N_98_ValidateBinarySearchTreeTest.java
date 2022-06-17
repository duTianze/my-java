package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/17
 */
class N_98_ValidateBinarySearchTreeTest {

    private final N_98_ValidateBinarySearchTree solution = new N_98_ValidateBinarySearchTree();

    @Test
    void isValidBST() {
        TreeNode root = new TreeNode(2, 1, 3);
        boolean validBST = solution.isValidBST(root);
        Assertions.assertTrue(validBST);
    }
}