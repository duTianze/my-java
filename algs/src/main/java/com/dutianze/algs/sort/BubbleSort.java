package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/21
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        for (int n = arr.length; n >= 1; n--) {
            bubble(arr, n);
        }
    }

    private void bubble(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }
}
