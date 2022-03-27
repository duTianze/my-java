package com.dutainze.algs.leetcode.array;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-good-pairs/">1512. Number of Good Pairs</a>
 * <h2>Easy</h2>
 * <pre>
 * Given an array of integers nums, return the number of good pairs.
 *
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 *
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 *
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 * Constraints:
 *
 *     1 <= nums.length <= 100
 *     1 <= nums[i] <= 100
 * </pre>
 *
 * @author dutianze
 * @date 2022/3/25
 */
@Component
public class N_1512_NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numIdenticalPairsBetter(int[] nums) {
        Map<Integer, Integer> hallMap = new HashMap<>();
        int ans = 0;
        for (int friend : nums) {
            Integer friendCount = hallMap.getOrDefault(friend, 0);
            ans = ans + friendCount;
            hallMap.put(friend, friendCount + 1);
        }
        return ans;
    }
}
