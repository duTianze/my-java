package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/21
 */
public interface Sort {

    void sort(int[] arr);

    default boolean isEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
