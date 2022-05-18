package com.dutianze.algs.leetcode.array;

/**
 * <a href="https://leetcode.com/problems/partition-equal-subset-sum/">416. Partition Equal Subset Sum</a>
 * <h2>Medium</h2>
 * <pre>
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 * Constraints:
 *
 *     1 <= nums.length <= 200
 *     1 <= nums[i] <= 100
 * </pre>
 *
 * @author dutianze
 * @date 2022/5/18
 */
public class N_416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足, 不装第i个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // dp[i - 1][j]                  不装第i个物品，i-1个物品能装满j容量 -> true
                    //                                            i-1个物品不能装满j容量 -> false
                    // dp[i - 1][j - nums[i - 1]]    装第i个物品, i-1个物品能装满j-nums[i-1]容量 -> true
                    //                                           i-1个物品不能装满j-nums[i-1]容量 -> false
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
