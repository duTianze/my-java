package com.dutianze.designpattern.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dutianze
 * @date 2022/8/14
 */
class ExpressionTest {

    @Test
    void testExpress1() {
        final String infixExpression = "( ( 1 + 2 ) *  2 )";
        String tokenString = infixToPostfix(infixExpression);

        int result = Expression.interpret(tokenString);
        assertEquals(6, result);
    }

    @Test
    void testExpress2() {
        final String infixExpression = "( ( 1 * 2 ) +  5 )";
        String tokenString = infixToPostfix(infixExpression);

        int result = Expression.interpret(tokenString);
        assertEquals(7, result);
    }

    private static String infixToPostfix(String infixExpression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] inputValues = infixExpression.split("\\s+");

        for (String value : inputValues) {
            switch (value) {
                case "(":
                    //do nothing
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(value);
                    break;
                case ")":
                    String value2 = operands.pop();
                    String value1 = operands.pop();
                    String operator = operators.pop();

                    String newExpression = value1 + " " + value2 + " " + operator;
                    operands.push(newExpression);
                    break;
                default:
                    operands.push(value);
                    break;
            }
        }
        return operands.pop();
    }
}