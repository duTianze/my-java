package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/23
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        int n = arr.length;
        while (n > 1) {
            int maxPos = findMaxPos(arr, n);
            swap(arr, maxPos, n - 1);
            n--;
        }
    }

    private int findMaxPos(int[] arr, int n) {
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[pos]) {
                pos = i;
            }
        }
        return pos;
    }
}
