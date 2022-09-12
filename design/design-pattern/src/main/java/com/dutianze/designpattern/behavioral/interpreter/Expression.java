package com.dutianze.designpattern.behavioral.interpreter;

import com.dutianze.designpattern.behavioral.interpreter.impl.MinusExpression;
import com.dutianze.designpattern.behavioral.interpreter.impl.MultiplyExpression;
import com.dutianze.designpattern.behavioral.interpreter.impl.NumberExpression;
import com.dutianze.designpattern.behavioral.interpreter.impl.PlusExpression;
import java.util.Stack;
import lombok.extern.slf4j.Slf4j;

/**
 * <h2 id="known-uses">Known uses</h2>
 * <ul>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html">java.util.Pattern</a></li>
 * <li><a href="http://docs.oracle.com/javase/8/docs/api/java/text/Normalizer.html">java.text.Normalizer</a></li>
 * <li>All subclasses of <a href="http://docs.oracle.com/javase/8/docs/api/java/text/Format.html">java.text.Format</a></li>
 * <li><a href="http://docs.oracle.com/javaee/7/api/javax/el/ELResolver.html">javax.el.ELResolver</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/8/14
 */
@Slf4j
public abstract class Expression {

  public abstract int interpret();

  @Override
  public abstract String toString();

  static int interpret(String tokenString) {
    Stack<Expression> stack = new Stack<>();
    String[] tokenList = tokenString.split(" ");
    for (String s : tokenList) {
      if (isOperator(s)) {
        Expression rightExpression = stack.pop();
        Expression leftExpression = stack.pop();
        log.info("popped from stack left: {} right: {}",
            leftExpression.interpret(), rightExpression.interpret());
        Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
        log.info("operator: {}", operator);
        int result = operator.interpret();
        NumberExpression resultExpression = new NumberExpression(result);
        stack.push(resultExpression);
        log.info("push result to stack: {}", resultExpression.interpret());
        continue;
      }
      NumberExpression i = new NumberExpression(s);
      stack.push(i);
      log.info("push to stack: {}", i.interpret());
    }
    return stack.pop().interpret();
  }

  private static Expression getOperatorInstance(String s, Expression left, Expression right) {
    return switch (s) {
      case "+" -> new PlusExpression(left, right);
      case "-" -> new MinusExpression(left, right);
      default -> new MultiplyExpression(left, right);
    };
  }

  private static boolean isOperator(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*");
  }
}