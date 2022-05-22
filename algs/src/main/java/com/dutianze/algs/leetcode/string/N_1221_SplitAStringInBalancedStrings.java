package com.dutianze.algs.leetcode.string;

/**
 * <a href="https://leetcode.com/problems/split-a-string-in-balanced-strings/">1221. Split a String in Balanced Strings</a>
 * <h2>Easy</h2>
 * <pre>
 * Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s, split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of split balanced strings.
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 *
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 *
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s[i] is either 'L' or 'R'.
 *     s is a balanced string.
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/22
 */
public class N_1221_SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int sum = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == 'L' ? 1 : -1;
            if (count == 0) {
                sum++;
            }
        }
        return sum;
    }
}
