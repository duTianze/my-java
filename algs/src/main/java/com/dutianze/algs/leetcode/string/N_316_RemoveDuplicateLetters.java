package com.dutianze.algs.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.com/problems/remove-duplicate-letters/description/">316. Remove Duplicate Letters</a>
 * <pre>
 *
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 * </pre>
 * @author dutianze
 * @date 2024/5/13
 */
public class N_316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }

            while (!deque.isEmpty() && deque.peek() > c) {
                if (count[deque.peek()] == 0) {
                    break;
                }
                inStack[deque.pop()] = false;
            }
            deque.push(c);
            inStack[c] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.removeLast());
        }
        return stringBuilder.toString();
    }
}
