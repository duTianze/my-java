package com.dutianze.algs.leetcode.array;

/**
 * @author dutianze
 * @date 2024/2/1
 */
public class N_26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[endIndex]) {
                endIndex++;
                nums[endIndex] = nums[i];
            }
        }
        return nums.length == 0 ? 0 : (endIndex + 1);
    }
}
