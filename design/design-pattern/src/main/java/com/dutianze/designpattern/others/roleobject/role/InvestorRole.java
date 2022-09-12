package com.dutianze.designpattern.others.roleobject.role;

import com.dutianze.designpattern.others.roleobject.core.CustomerRole;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class InvestorRole extends CustomerRole {

  private String name;

  private long amountToInvest;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getAmountToInvest() {
    return amountToInvest;
  }

  public void setAmountToInvest(long amountToInvest) {
    this.amountToInvest = amountToInvest;
  }

  public String invest() {
    return String.format("Investor %s has invested %d dollars", name, amountToInvest);
  }
}
