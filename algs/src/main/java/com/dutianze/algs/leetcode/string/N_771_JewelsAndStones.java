package com.dutianze.algs.leetcode.string;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/jewels-and-stones/">771. Jewels and Stones</a>
 * <h2>Easy</h2>
 * <pre>
 * You're given strings jewels representing the types of stones that are jewels,
 * and stones representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 *
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 *
 * Constraints:
 *
 *     1 <= jewels.length, stones.length <= 50
 *     jewels and stones consist of only English letters.
 *     All the characters of jewels are unique.
 * </pre>
 *
 * @author dutianze
 * @date 2022/4/3
 */
public class N_771_JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> jewelsSet = jewels.chars()
                                         .mapToObj(c -> (char) c)
                                         .collect(Collectors.toSet());
        for (char c : stones.toCharArray()) {
            if (jewelsSet.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
