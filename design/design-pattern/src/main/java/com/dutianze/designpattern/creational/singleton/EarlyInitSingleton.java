package com.dutianze.designpattern.creational.singleton;

/**
 * @author dutianze
 * @date 2022/6/30
 */
public class EarlyInitSingleton {

  private EarlyInitSingleton() {
  }

  private static final EarlyInitSingleton INSTANCE = new EarlyInitSingleton();

  public static EarlyInitSingleton getInstance() {
    return INSTANCE;
  }
}
