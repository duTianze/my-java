package com.dutianze.designpattern.creational.factory.coin.impl;

import com.dutianze.designpattern.creational.factory.coin.Coin;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class GoldCoin implements Coin {

  static final String DESCRIPTION = "This is a gold coin.";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
