package com.dutianze.designpattern.others.strangler.old;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class OldArithmetic {

    private static final String VERSION = "1.0";

    private final OldSource source;

    public OldArithmetic(OldSource source) {
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
}
