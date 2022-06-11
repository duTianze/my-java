package com.dutianze.algs.leetcode.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/11
 */
class N_116_PopulatingNextRightPointersInEachNodeTest {

    private final N_116_PopulatingNextRightPointersInEachNode solution =
            new N_116_PopulatingNextRightPointersInEachNode();

    @Test
    void connect() {
        TreeNode root = new TreeNode(1, 2, 3, 4, 5, 6, 7);

        TreeNode result = solution.connect(root);

        TreeNode byVal2 = result.findByVal(2);
        TreeNode byVal3 = result.findByVal(3);

        Assertions.assertEquals(byVal3, byVal2.next);
    }

    @Test
    void connectWithQueue() {
        TreeNode root = new TreeNode(1, 2, 3, 4, 5, 6, 7);

        TreeNode result = solution.connectWithQueue(root);

        TreeNode byVal2 = result.findByVal(2);
        TreeNode byVal3 = result.findByVal(3);

        Assertions.assertEquals(byVal3, byVal2.next);
    }
}