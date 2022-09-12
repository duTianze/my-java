package com.dutianze.designpattern.others.specialcase.dto.impl;

import com.dutianze.designpattern.others.specialcase.dto.ReceiptViewModel;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class InsufficientFunds implements ReceiptViewModel {

  private final String userName;
  private final Double amount;
  private final String itemName;

  public InsufficientFunds(String userName, Double amount, String itemName) {
    this.userName = userName;
    this.amount = amount;
    this.itemName = itemName;
  }

  @Override
  public void show() {
    log.warn("Insufficient funds: {} of user: {} for buying item: {}", amount, userName, itemName);
  }
}
