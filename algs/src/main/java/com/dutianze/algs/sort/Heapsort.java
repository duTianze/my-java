package com.dutianze.algs.sort;

/**
 * @author dutianze
 * @date 2022/6/27
 */
public class Heapsort implements Sort {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        int n = array.length;

        for (int i = Math.max(0, (n / 2) - 1); i >= 0; i--) {
            sink(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            sink(array, i, 0);
        }
        return array;
    }

    private void sink(int[] ar, int n, int i) {
        while (true) {
            int left = 2 * i + 1; // Left  node
            int right = 2 * i + 2; // Right node
            int largest = i;

            // Right child is larger than parent
            if (right < n && ar[right] > ar[largest]) {largest = right;}

            // Left child is larger than parent
            if (left < n && ar[left] > ar[largest]) {largest = left;}

            // Move down the tree following the largest node
            if (largest != i) {
                swap(ar, largest, i);
                i = largest;
            } else {break;}
        }
    }
}
