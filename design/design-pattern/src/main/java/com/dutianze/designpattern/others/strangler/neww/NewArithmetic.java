package com.dutianze.designpattern.others.strangler.neww;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class NewArithmetic {

    private static final String VERSION = "2.0";

    private final NewSource source;

    public NewArithmetic(NewSource source) {
        this.source = source;
    }

    public int sum(int... nums) {
        log.info("Arithmetic sum {}", VERSION);
        return source.accumulateSum(nums);
    }

    public int mul(int... nums) {
        log.info("Arithmetic mul {}", VERSION);
        return source.accumulateMul(nums);
    }

    public boolean ifHasZero(int... nums) {
        log.info("Arithmetic check zero {}", VERSION);
        return !source.ifNonZero(nums);
    }
}
