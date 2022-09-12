package com.dutianze.designpattern.others.strangler.half;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class HalfSource {

  private static final String VERSION = "1.5";

  public int accumulateSum(int... nums) {
    log.info("Source module {}", VERSION);
    return Arrays.stream(nums).reduce(0, Integer::sum);
  }


  public boolean ifNonZero(int... nums) {
    log.info("Source module {}", VERSION);
    return Arrays.stream(nums).allMatch(num -> num != 0);
  }
}
