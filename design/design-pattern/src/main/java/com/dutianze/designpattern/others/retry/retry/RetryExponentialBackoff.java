package com.dutianze.designpattern.others.retry.retry;

import com.dutianze.designpattern.others.retry.exception.BusinessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public final class RetryExponentialBackoff<T> implements BusinessOperation<T> {

  private static final Random RANDOM = new Random();
  private final BusinessOperation<T> op;
  private final int maxAttempts;
  private final long maxDelay;
  private final AtomicInteger attempts;
  private final Predicate<Exception> ignoreTests;
  private final List<Exception> errors;

  @SafeVarargs
  public RetryExponentialBackoff(BusinessOperation<T> op, int maxAttempts, long maxDelay,
      Predicate<Exception>... ignoreTests) {
    this.op = op;
    this.maxAttempts = maxAttempts;
    this.maxDelay = maxDelay;
    this.attempts = new AtomicInteger();
    this.ignoreTests = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
    this.errors = new ArrayList<>();
  }

  public List<Exception> errors() {
    return Collections.unmodifiableList(this.errors);
  }

  public int attempts() {
    return this.attempts.intValue();
  }

  @SuppressWarnings("BusyWait")
  @Override
  public T perform() throws BusinessException {
    do {
      try {
        return this.op.perform();
      } catch (BusinessException e) {
        this.errors.add(e);

        if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.ignoreTests.test(e)) {
          throw e;
        }
        try {
          long testDelay = (long) Math.pow(2, this.attempts()) * 1000 + RANDOM.nextInt(1000);
          long delay = Math.min(testDelay, this.maxDelay);
          Thread.sleep(delay);
        } catch (InterruptedException f) {
          //ignore
        }
      }
    } while (true);
  }
}
