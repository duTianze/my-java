package com.dutianze.designpattern.creational.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static DoubleCheckSingleton getInstance() {
        DoubleCheckSingleton result = instance;
        if (result == null) {
            synchronized (DoubleCheckSingleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new DoubleCheckSingleton();
                }
            }
        }
        return result;
    }
}
