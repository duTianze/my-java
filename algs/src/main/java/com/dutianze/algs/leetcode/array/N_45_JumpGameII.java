package com.dutianze.algs.leetcode.array;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">45. Jump Game II</a>
 * <pre>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 1000
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/20
 */
public class N_45_JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0, jumps = 0, farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(i + nums[i], farthest);
            if (i == end) {
                end = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
