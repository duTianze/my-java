package com.dutianze.designpattern.others.strangler.old;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class OldSource {

  private static final String VERSION = "1.0";

  public int accumulateSum(int... nums) {
    log.info("Source module {}", VERSION);
    int sum = 0;
    for (final int num : nums) {
      sum += num;
    }
    return sum;
  }

  public int accumulateMul(int... nums) {
    log.info("Source module {}", VERSION);
    int sum = 1;
    for (final int num : nums) {
      sum *= num;
    }
    return sum;
  }
}
