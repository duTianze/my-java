package com.dutianze.algs.leetcode.sort;

/**
 * @author dutianze
 * @date 2022/6/24
 */
public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j - 1, j);
            }
        }
        return array;
    }
}
