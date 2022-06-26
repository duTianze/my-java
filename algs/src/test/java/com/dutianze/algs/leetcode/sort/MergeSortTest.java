package com.dutianze.algs.leetcode.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/6/26
 */
class MergeSortTest {

    private final MergeSort sort = new MergeSort();

    @Test
    void sort() {
        int[] array = {5, 1, 4, 2, 8};
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        int[] sorted = sort.sort(array);

        Assertions.assertArrayEquals(expected, sorted);
    }
}