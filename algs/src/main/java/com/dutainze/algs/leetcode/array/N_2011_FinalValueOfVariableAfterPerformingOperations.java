package com.dutainze.algs.leetcode.array;

/**
 * @author dutianze
 * @date 2022/3/17
 */
public class N_2011_FinalValueOfVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int num = 0;
        for (String operation : operations) {
            if (operation.contains("++")) {
                num ++;
            } else if (operation.contains("--")) {
                num --;
            }
        }
        return num;
    }
}
