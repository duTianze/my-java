package com.dutianze.algs.leetcode.dp;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">5. Longest Palindromic Substring</a>
 * <h2>Medium</h2>
 * <pre>
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 *
 *     1 <= s.length <= 1000
 *     s consist of only digits and English letters.
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/19
 */
public class N_5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = this.extendStr(s, i, i);
            String s2 = this.extendStr(s, i, i + 1);
            maxPalindrome = maxPalindrome.length() > s1.length() ? maxPalindrome : s1;
            maxPalindrome = maxPalindrome.length() > s2.length() ? maxPalindrome : s2;
        }
        return maxPalindrome;
    }

    private String extendStr(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}
