package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/21
 */
public interface Sort {
    int[] sort(int[] array);

    default void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
