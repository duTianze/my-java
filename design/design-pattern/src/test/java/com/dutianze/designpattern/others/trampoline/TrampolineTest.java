package com.dutianze.designpattern.others.trampoline;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/21
 */
class TrampolineTest {

  @Test
  void factorialTest() {
    Integer trampoline = factorial(10, 1).compute();
    int recursion = factorial(10);

    assertEquals(recursion, trampoline);
  }

  @Test
  void fibonacciTest() {
    Integer trampoline = fibonacci(10, 0, 1).compute();
    int recursion = fibonacci(10);

    assertEquals(recursion, trampoline);
  }

  private Trampoline<Integer> factorial(int number, int sum) {
    return number == 1
        ? Trampoline.done(sum)
        : Trampoline.more(() -> factorial(number - 1, sum * number));
  }

  public int factorial(int n) {
    if (n <= 2) {
      return n;
    }
    return n * factorial(n - 1);
  }

  public Trampoline<Integer> fibonacci(int count, int a, int b) {
    return count == 0
        ? Trampoline.done(a)
        : Trampoline.more(() -> fibonacci(count - 1, b, a + b));
  }

  public int fibonacci(int number) {
    if ((number == 0) || (number == 1)) {
      return number;
    }
    return fibonacci(number - 1) + fibonacci(number - 2);
  }
}