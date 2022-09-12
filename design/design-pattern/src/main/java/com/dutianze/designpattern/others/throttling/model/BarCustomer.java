package com.dutianze.designpattern.others.throttling.model;

import com.dutianze.designpattern.others.throttling.timer.CallsCount;
import java.security.InvalidParameterException;
import lombok.Getter;

/**
 * @author dutianze
 * @date 2022/8/22
 */
public class BarCustomer {

  @Getter
  private final String name;
  @Getter
  private final int allowedCallsPerSecond;

  public BarCustomer(String name, int allowedCallsPerSecond, CallsCount callsCount) {
    if (allowedCallsPerSecond < 0) {
      throw new InvalidParameterException("Number of calls less than 0 not allowed");
    }
    this.name = name;
    this.allowedCallsPerSecond = allowedCallsPerSecond;
    callsCount.addTenant(name);
  }
}
