package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class InnerClassSingleton {

    /**
     * Private constructor.
     */
    private InnerClassSingleton() {
    }

    /**
     * Singleton instance.
     *
     * @return Singleton instance
     */
    public static InnerClassSingleton getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }
}
