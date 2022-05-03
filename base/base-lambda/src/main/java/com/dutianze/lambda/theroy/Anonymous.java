package com.dutianze.lambda.theroy;

/**
 * 1. javac Anonymous.java
 * 2. javap -c Anonymous.class
 *
 * @author dutianze
 * @date 2022/5/1
 */
public class Anonymous {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();
    }
}
