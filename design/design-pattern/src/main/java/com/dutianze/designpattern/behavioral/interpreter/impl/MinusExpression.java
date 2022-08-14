package com.dutianze.designpattern.behavioral.interpreter.impl;

import com.dutianze.designpattern.behavioral.interpreter.Expression;

/**
 * @author dutianze
 * @date 2022/8/14
 */
public class MinusExpression extends Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public MinusExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }

    @Override
    public String toString() {
        return "-";
    }

}