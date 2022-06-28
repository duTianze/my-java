package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/27
 */
public class Heapsort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        int n = arr.length;

        for (int i = Math.max(0, (n / 2) - 1); i >= 0; i--) {
            sink(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            sink(arr, i, 0);
        }
    }

    private void sink(int[] arr, int n, int i) {
        while (true) {
            int left = 2 * i + 1; // Left  node
            int right = 2 * i + 2; // Right node
            int largest = i;

            // Right child is larger than parent
            if (right < n && arr[right] > arr[largest]) {largest = right;}

            // Left child is larger than parent
            if (left < n && arr[left] > arr[largest]) {largest = left;}

            // Move down the tree following the largest node
            if (largest != i) {
                swap(arr, largest, i);
                i = largest;
            } else {break;}
        }
    }
}
