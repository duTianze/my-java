package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/24
 */
public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }
}
