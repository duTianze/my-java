package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class DemandHolderSingleton {

    private DemandHolderSingleton() {
    }

    private static class HelperHolder {
        private static final DemandHolderSingleton INSTANCE = new DemandHolderSingleton();
    }

    public static DemandHolderSingleton getInstance() {
        return HelperHolder.INSTANCE;
    }
}