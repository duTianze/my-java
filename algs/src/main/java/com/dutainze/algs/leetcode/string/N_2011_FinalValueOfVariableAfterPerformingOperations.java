package com.dutainze.algs.leetcode.string;

/**
 * @author dutianze
 * @date 2022/3/30
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
