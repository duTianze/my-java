package com.dutianze.designpattern.others.strangler.half;

import com.dutianze.designpattern.others.strangler.old.OldSource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class HalfArithmetic {

  private static final String VERSION = "1.5";

  private final HalfSource newSource;
  private final OldSource oldSource;

  public HalfArithmetic(HalfSource newSource, OldSource oldSource) {
    this.newSource = newSource;
    this.oldSource = oldSource;
  }

  public int sum(int... nums) {
    log.info("Arithmetic sum {}", VERSION);
    return newSource.accumulateSum(nums);
  }

  public int mul(int... nums) {
    log.info("Arithmetic mul {}", VERSION);
    return oldSource.accumulateMul(nums);
  }

  public boolean ifHasZero(int... nums) {
    log.info("Arithmetic check zero {}", VERSION);
    return !newSource.ifNonZero(nums);
  }
}
