package com.dutianze.algs.leetcode.string;

/**
 * <a href="https://leetcode.com/problems/count-binary-substrings/description/">696. Count Binary Substrings</a>
 * <pre>
 *
 * Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * </pre>
 * @author dutianze
 * @date 2024/5/13
 */
public class N_696_CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int point = 0;
        int n = s.length();
        int last = 0;
        int result = 0;
        while (point < n) {
            char c  = s.charAt(point);
            int count = 0;
            while (point < n && s.charAt(point) == c) {
                point++;
                count++;
            }
            result += Math.min(last, count);
            last = count;
        }
        return result;
    }
}
