package com.dutianze.algs.interview;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author dutianze
 * @date 2024/5/13
 */
public class Test {

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            // Write your code here
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }

    public static String getString(String input_str) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input_str.length(); i++) {
            lastIndex.put(input_str.charAt(i), i);
        }
        for (int i = 0; i < input_str.length(); i++) {
            char currentChar = input_str.charAt(i);
            if (used.contains(currentChar)) {
                continue;
            }
            while (result.length() > 0 && result.charAt(result.length() - 1) < currentChar &&
                   i < lastIndex.get(result.charAt(result.length() - 1))) {
                used.remove(result.charAt(result.length() - 1));
                result.deleteCharAt(result.length() - 1);
            }
            result.append(currentChar);
            used.add(currentChar);
        }
        return result.toString();
    }

    public static int countBinarySubstrings(String s) {
        int count = 0;
        int prevLength = 0;
        int currLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLength++;
            } else {
                count += Math.min(prevLength, currLength);
                prevLength = currLength;
                currLength = 1;
            }
        }
        count += Math.min(prevLength, currLength);
        return count;
    }

    public static void main(String[] args) {

        System.out.println(getString("abacaba"));

        System.out.println(countBinarySubstrings("001100011"));

    }
}
