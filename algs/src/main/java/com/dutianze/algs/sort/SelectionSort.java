package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/23
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (isEmpty(array)) {
            return;
        }
        final int N = array.length;
        for (int i = 0; i < N; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (array[j] < array[swapIndex]) {
                    swapIndex = j;
                }
            }
            swap(array, i, swapIndex);
        }
    }
}
