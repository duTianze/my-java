package com.dutianze.lambda.theroy;

/**
 * 1. javac MainLambda.java
 * 2. javap -c -p MainLambda.class
 *
 * @author dutianze
 * @date 2022/5/1
 */
public class MainLambda {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("Anonymous Class Thread run()")).start();
    }
}
