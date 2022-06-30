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
            insert(arr, i);
        }
    }

    private void insert(int[] arr, int n) {
        int k = arr[n];
        int i = n;
        while (i > 0 && arr[i - 1] > k) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[i] = k;
    }

}
