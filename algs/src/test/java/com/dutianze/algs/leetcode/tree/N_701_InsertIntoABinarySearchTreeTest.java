package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/18
 */
class N_701_InsertIntoABinarySearchTreeTest {

    private final N_701_InsertIntoABinarySearchTree solution = new N_701_InsertIntoABinarySearchTree();

    @Test
    void insertIntoBST() {
        TreeNode root = new TreeNode(4, 2, 7, 1, 3);
        TreeNode expected = new TreeNode(4, 2, 7, 1, 3, 5);

        TreeNode result = solution.insertIntoBST(root, 5);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
}