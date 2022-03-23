package com.dutainze.algs.leetcode.array;

import com.dutainze.util.PrettyPrinter;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/3/21
 */
public class N_1476_SubrectangleQueries {

    private final int[][] rectangle;

    public N_1476_SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }

    @Override
    public String toString() {
        PrettyPrinter prettyPrinter = new PrettyPrinter(System.out);
        return prettyPrinter.print(rectangle);
    }
}
