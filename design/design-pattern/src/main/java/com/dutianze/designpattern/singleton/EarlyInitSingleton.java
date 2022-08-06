package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class EarlyInitSingleton {

    /**
     * Private constructor so nobody can instantiate the class.
     */
    private EarlyInitSingleton() {
    }

    /**
     * Static to class instance of the class.
     */
    private static final EarlyInitSingleton INSTANCE = new EarlyInitSingleton();

    /**
     * To be called by user to obtain instance of the class.
     *
     * @return instance of the singleton.
     */
    public static EarlyInitSingleton getInstance() {
        return INSTANCE;
    }
}
