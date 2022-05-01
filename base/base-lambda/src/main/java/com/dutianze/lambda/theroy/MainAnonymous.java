package com.dutianze.lambda.theroy;

/**
 * 1. javac MainAnonymous.java
 * 2. javap -c MainAnonymous.class
 *
 * @author dutianze
 * @date 2022/5/1
 */
public class MainAnonymous {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Class Thread run()");
            }
        }).start();
    }
}
