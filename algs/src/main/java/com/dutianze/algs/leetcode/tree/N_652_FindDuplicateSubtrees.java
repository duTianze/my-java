package com.dutianze.algs.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/find-duplicate-subtrees/">652. Find Duplicate Subtrees</a>
 * <h2>Medium</h2>
 * <pre>
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 *
 * Example 2:
 *
 * Input: root = [2,1,1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 *
 * Constraints:
 *
 *     The number of the nodes in the tree will be in the range [1, 10^4]
 *     -200 <= Node.val <= 200
 * </pre>
 *
 * @author dutianze
 * @date 2022/6/7
 */
public class N_652_FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        serialize(root, new HashMap<>(), result);
        return result;
    }

    private String serialize(TreeNode curr, Map<String, Integer> map, List<TreeNode> result) {
        if (curr == null) {
            return "#";
        }
        String serial = curr.val + "," + serialize(curr.left, map, result) + "," + serialize(curr.right, map, result);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial).equals(2)) {
            result.add(curr);
        }
        return serial;
    }
}
