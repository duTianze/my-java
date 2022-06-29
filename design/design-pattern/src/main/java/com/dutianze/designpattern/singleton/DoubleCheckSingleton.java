package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    /**
     * private constructor to prevent client from instantiating.
     */
    private DoubleCheckSingleton() {
        // to prevent instantiating by Reflection call
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * Public accessor.
     *
     * @return an instance of the class.
     */
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
