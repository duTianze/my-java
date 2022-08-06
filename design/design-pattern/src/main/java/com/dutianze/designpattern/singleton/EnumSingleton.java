package com.dutianze.designpattern.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public enum EnumSingleton {

    INSTANCE("Initial class info");

    private final String info;

    EnumSingleton(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
