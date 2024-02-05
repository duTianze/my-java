package com.dutianze.others;

/**
 * @author dutianze
 * @date 2024/2/2
 */
public class roman {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            String roman = toRoman(i);
            if (roman.length() == 9) {
                System.out.println(i + " -> " + roman);
                sum += i;
            }
        }
        System.out.println("合计: " + sum);
    }

    private static String toRoman(int number) {
        if (number < 1 || number > 3999) {
            return "Invalid number";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        int i = 0;

        while (number > 0) {
            if (number - values[i] >= 0) {
                roman.append(symbols[i]);
                number -= values[i];
            } else {
                i++;
            }
        }

        return roman.toString();
    }
}
