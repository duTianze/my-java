package com.dutianze.designpattern.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class ExpressionTest {

    @Test
    void testExpress() {
        final String tokenString = "4 3 2 - 1 + *";

        int result = Expression.interpret(tokenString);

        assertEquals(8, result);
    }
}