package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/22
 */
public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex, right);
        }
    }

    private int partition(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (numbers[j] <= pivot) {
                swap(numbers, ++i, j);
            }
        }
        swap(numbers, ++i, right);
        return i;
    }
}
