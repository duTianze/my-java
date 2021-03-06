package com.dutianze.algs.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/6/22
 */
class QuickSortTest {

    private final QuickSort sort = new QuickSort();

    @Test
    void sort() {
        int[] array = {5, 1, 4, 2, 8};
        int[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);

        sort.sort(array);

        Assertions.assertArrayEquals(expected, array);
    }
}