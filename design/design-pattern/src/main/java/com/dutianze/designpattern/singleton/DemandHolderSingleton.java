package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class DemandHolderSingleton {

    /**
     * Private constructor.
     */
    private DemandHolderSingleton() {
    }

    /**
     * Singleton instance.
     *
     * @return Singleton instance
     */
    public static DemandHolderSingleton getInstance() {
        return HelperHolder.INSTANCE;
    }

    /**
     * Provides the lazy-loaded Singleton instance.
     */
    private static class HelperHolder {
        private static final DemandHolderSingleton INSTANCE = new DemandHolderSingleton();
    }
}
