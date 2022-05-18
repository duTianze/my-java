package com.dutianze.algs.leetcode.array;

/**
 * <a href="https://leetcode.com/problems/jump-game/">55. Jump Game</a>
 * <h2>Medium</h2>
 * <pre>
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * which makes it impossible to reach the last index.
 *
 * Constraints:
 *
 *     1 <= nums.length <= 104
 *     0 <= nums[i] <= 105
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/18
 */
public class N_55_JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}
