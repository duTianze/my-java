package com.dutianze.algs.leetcode.list;

import com.dutianze.algs.leetcode.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/6/13
 */
class N_109_ConvertSortedListToBinarySearchTreeTest {

    private final N_109_ConvertSortedListToBinarySearchTree solution = new N_109_ConvertSortedListToBinarySearchTree();

    @Test
    void sortedListToBST() {
        ListNode listNode = ListNode.with(-10, -3, 0, 5, 9);

        TreeNode treeNode = solution.sortedListToBST(listNode);

        Assertions.assertNull(treeNode.findByVal(-3).right);
    }
}