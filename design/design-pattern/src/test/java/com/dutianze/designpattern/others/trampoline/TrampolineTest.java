package com.dutianze.designpattern.others.trampoline;

import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/21
 */
class TrampolineTest {

    @Test
    void factorialTest() {
        Integer result = factorial(10, 1).compute();
        System.out.println(result);
    }

    private Trampoline<Integer> factorial(int number, int sum) {
        return number == 1
               ? Trampoline.done(sum)
               : Trampoline.more(() -> factorial(number - 1, sum * number));
    }
}