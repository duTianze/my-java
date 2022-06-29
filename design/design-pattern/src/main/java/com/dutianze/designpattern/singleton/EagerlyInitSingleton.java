package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class EagerlyInitSingleton {

    /**
     * Private constructor so nobody can instantiate the class.
     */
    private EagerlyInitSingleton() {
    }

    /**
     * Static to class instance of the class.
     */
    private static final EagerlyInitSingleton INSTANCE = new EagerlyInitSingleton();

    /**
     * To be called by user to obtain instance of the class.
     *
     * @return instance of the singleton.
     */
    public static EagerlyInitSingleton getInstance() {
        return INSTANCE;
    }
}
