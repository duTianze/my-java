package com.dutianze.algs.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pascals-triangle-ii/description/">119. Pascal's Triangle II</a>
 * <pre>
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 *
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 *
 * Input: rowIndex = 1
 * Output: [1,1]
 *
 *
 * Constraints:
 *
 * 0 <= rowIndex <= 33
 *
 *
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 * </pre>
 *
 * @author dutianze
 * @date 2024/3/12
 */
public class N_119_PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }
        return row;
    }
}
