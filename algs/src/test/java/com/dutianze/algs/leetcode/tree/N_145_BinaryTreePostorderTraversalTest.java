package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/5/28
 */
class N_145_BinaryTreePostorderTraversalTest {

    private final N_145_BinaryTreePostorderTraversal solution = new N_145_BinaryTreePostorderTraversal();

    @Test
    void postorderTraversal() {
        TreeNode treeNode = new TreeNode(1, null, 2, 3);

        List<Integer> result = solution.postorderTraversal(treeNode);

        Assertions.assertEquals(List.of(3,2,1), result);
    }
}