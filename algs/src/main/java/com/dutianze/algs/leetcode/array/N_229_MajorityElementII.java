package com.dutianze.algs.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/majority-element-ii/description/">229. Majority Element II</a>
 * <pre>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 * </pre>
 *
 * @author dutianze
 * @date 2024/3/12
 */
public class N_229_MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int vote1 = 0, vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && candidate1 == num) {
                vote1++;
                continue;
            }
            if (vote2 > 0 && candidate2 == num) {
                vote2++;
                continue;
            }
            if (vote1 == 0) {
                candidate1 = num;
                vote1 = 1;
                continue;
            }
            if (vote2 == 0) {
                candidate2 = num;
                vote2 = 1;
                continue;
            }
            vote1--;
            vote2--;
        }

        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }
        return result;
    }
}
