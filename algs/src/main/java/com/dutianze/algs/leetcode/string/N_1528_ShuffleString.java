package com.dutianze.algs.leetcode.string;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/shuffle-string/">1528. Shuffle String</a>
 * <h2>Easy</h2>
 * <pre>
 * You are given a string s and an integer array indices of the same length. The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 * Example 1:
 *
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 *
 * Example 2:
 *
 * Input: s = "abc", indices = [0,1,2]
 * Output: "abc"
 * Explanation: After shuffling, each character remains in its position.
 *
 * Constraints:
 *
 *     s.length == indices.length == n
 *     1 <= n <= 100
 *     s consists of only lowercase English letters.
 *     0 <= indices[i] < n
 *     All values of indices are unique.
 * Return the shuffled string.
 * </pre>
 * @author dutianze
 * @date 2022/4/4
 */
public class N_1528_ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = chars[i];
        }
        return new String(result);
    }
}
