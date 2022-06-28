package com.dutianze.algs.sort;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/6/26
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (isEmpty(arr)) {
            return;
        }
        arr = mergeSort(arr);
    }

    public int[] mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {return arr;}

        // Split array into two parts and recursively sort them
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, n / 2));
        int[] right = mergeSort(Arrays.copyOfRange(arr, n / 2, n));

        // Combine the two arrays into one larger array
        return merge(left, right);
    }

    private static int[] merge(int[] ar1, int[] ar2) {
        int n1 = ar1.length, n2 = ar2.length;
        int n = n1 + n2, i1 = 0, i2 = 0;
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            if (i1 == n1) {
                ar[i] = ar2[i2++];
            } else if (i2 == n2) {
                ar[i] = ar1[i1++];
            } else {
                if (ar1[i1] < ar2[i2]) {
                    ar[i] = ar1[i1++];
                } else {
                    ar[i] = ar2[i2++];
                }
            }
        }
        return ar;
    }
}
