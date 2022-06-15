package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/15
 */
class N_700_SearchInABinarySearchTreeTest {

    private final N_700_SearchInABinarySearchTree solution = new N_700_SearchInABinarySearchTree();

    @Test
    void searchBST() {
        TreeNode root = new TreeNode(4, 2, 7, 1, 3);

        TreeNode result = solution.searchBST(root, 2);

        Assertions.assertEquals(result.findByVal(2).toString(), result.toString());
    }
}