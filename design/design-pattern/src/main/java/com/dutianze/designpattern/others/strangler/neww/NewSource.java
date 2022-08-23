package com.dutianze.designpattern.others.strangler.neww;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author dutianze
 * @date 2022/8/24
 */
@Slf4j
public class NewSource {

    private static final String VERSION = "2.0";
    public static final String SOURCE_MODULE = "Source module {}";

    public int accumulateSum(int... nums) {
        log.info(SOURCE_MODULE, VERSION);
        return Arrays.stream(nums).reduce(0, Integer::sum);
    }

    public int accumulateMul(int... nums) {
        log.info(SOURCE_MODULE, VERSION);
        return Arrays.stream(nums).reduce(1, (a, b) -> a * b);
    }

    public boolean ifNonZero(int... nums) {
        log.info(SOURCE_MODULE, VERSION);
        return Arrays.stream(nums).allMatch(num -> num != 0);
    }
}
