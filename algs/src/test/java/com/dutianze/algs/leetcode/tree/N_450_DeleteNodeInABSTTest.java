package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/10
 */
class N_450_DeleteNodeInABSTTest {

    private final N_450_DeleteNodeInABST solution = new N_450_DeleteNodeInABST();

    @Test
    void deleteNode() {
        TreeNode root = new TreeNode(5, 3, 6, 2, 4, null, 7);
        TreeNode expected = new TreeNode(5, 4, 6, 2, null, null, 7);

        TreeNode result = solution.deleteNode(root, 3);

        Assertions.assertEquals(expected.toString(), result.toString());
    }
}