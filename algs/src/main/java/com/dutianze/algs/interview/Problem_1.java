package com.dutianze.algs.interview;

import java.util.List;

/**
 * @author dutianze
 * @date 2024/4/2
 */
public class Problem_1 {

    public static int calcFn(int num) {
        if (num % 3 == 0) {
            return calcFn(num / 3 ) + 3;
        }

        if (num % 5 == 0) {
            return calcFn(num / 5) + 5;
        }

        if (num % 7 == 0) {
            return calcFn(num / 7 ) + 7;
        }
        return num;
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long repetitionCount = n / s.length();
        long countOfA = s.chars().filter(ch -> ch == 'a').count();
        long remainingCountOfA = s.chars().limit(n % s.length()).filter(ch -> ch == 'a').count();
        return countOfA * repetitionCount + remainingCountOfA;
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int high = 0;
        int valleys = 0;
        for (char c : path.toCharArray()) {
            int preHigh = high;
            if (c == 'U') {
                high ++;
            } else if(c == 'D') {
                high --;
            }
            if (preHigh >= 0 && high < 0) {
                valleys ++;
            }
        }
        return valleys;
    }


    private static int calculateHourglassSum(List<List<Integer>> arr, int row, int col) {
        int sum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (!((i == row + 1 && j == col) || (i == row + 1 && j == col + 2))) {
                    sum += arr.get(i).get(j);
                }
            }
        }
        return sum;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = 0; j <= arr.get(i).size() - 3; j++) {
                int currentSum = calculateHourglassSum(arr, i, j);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }
}
