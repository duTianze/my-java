package com.dutianze.algs.leetcode.array;

/**
 * <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">1662. Check If Two String Arrays are Equivalent</a>
 * <h2>Easy</h2>
 * <pre>
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 * Example 1:
 *
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 *
 * Example 2:
 *
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 *
 * Example 3:
 *
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 *
 * Constraints:
 *
 *     1 <= word1.length, word2.length <= 103
 *     1 <= word1[i].length, word2[i].length <= 103
 *     1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 *     word1[i] and word2[i] consist of lowercase letters.
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/21
 */
public class N_1662_CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        return s1.equals(s2);
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int p1 = 0, p2 = 0; // inner pointer
        int w1 = 0, w2 = 0; // outer pointer

        while (w1 < word1.length && w2 < word2.length) {
            String curr1 = word1[w1], curr2 = word2[w2];

            if (curr1.charAt(p1) != curr2.charAt(p2)) {
                return false;
            }

            if (p1 < curr1.length() - 1) {
                p1++;
            } else {
                p1 = 0;
                w1++;
            }

            if (p2 < curr2.length() - 1) {
                p2++;
            } else {
                p2 = 0;
                w2++;
            }
        }

        return w1 == word1.length && w2 == word2.length;
    }

}
