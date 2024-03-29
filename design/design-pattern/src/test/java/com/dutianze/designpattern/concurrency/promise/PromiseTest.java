package com.dutianze.designpattern.concurrency.promise;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.dutianze.designpattern.concurrency.promise.support.Utility;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/31
 */
@Slf4j
class PromiseTest {

  private static final String DEFAULT_URL =
      "https://raw.githubusercontent.com/iluwatar/java-design-patterns/master/promise/README.md";
  private static final CountDownLatch stopLatch = new CountDownLatch(2);
  private static final ExecutorService executor = Executors.newFixedThreadPool(2);

  private Promise<Integer> promise;

  @BeforeEach
  public void setUp() {
    promise = new Promise<>();
  }

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      download(DEFAULT_URL)
          .thenApply(Utility::countLines)
          .thenAccept(
              count -> {
                log.info("Line count is: {}", count);
                stopLatch.countDown();
              }
          );
      download(DEFAULT_URL)
          .thenApply(Utility::characterFrequency)
          .thenApply(Utility::lowestFrequencyChar)
          .thenAccept(
              charFrequency -> {
                log.info("Char with lowest frequency is: {}", charFrequency);
                stopLatch.countDown();
              }
          );
      stopLatch.await();
      executor.shutdownNow();
    });
  }

  @Test
  void dependentPromiseIsFulfilledAfterTheConsumerConsumesTheResultOfThisPromise()
      throws InterruptedException, ExecutionException {
    Promise<Void> dependentPromise = promise
        .fulfillInAsync(new NumberCrunchingTask(), executor)
        .thenAccept(value -> assertEquals(NumberCrunchingTask.CRUNCHED_NUMBER, value));

    dependentPromise.get();
    assertTrue(dependentPromise.isDone());
    assertFalse(dependentPromise.isCancelled());
  }

  @Test
  void fetchingAnAlreadyFulfilledPromiseReturnsTheFulfilledValueImmediately()
      throws ExecutionException {
    Promise<Integer> promise = new Promise<>();
    promise.fulfill(NumberCrunchingTask.CRUNCHED_NUMBER);

    Integer result = promise.get(1000, TimeUnit.SECONDS);
    assertEquals(NumberCrunchingTask.CRUNCHED_NUMBER, result);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Test
  void exceptionHandlerIsCalledWhenPromiseIsFulfilledExceptionally() {
    Promise<Object> promise = new Promise<>();
    Consumer exceptionHandler = mock(Consumer.class);
    promise.onError(exceptionHandler);

    Exception exception = new Exception("barf!");
    promise.fulfillExceptionally(exception);

    verify(exceptionHandler).accept(eq(exception));
  }

  private Promise<String> download(String urlString) {
    return new Promise<String>()
        .fulfillInAsync(() -> Utility.downloadFile(urlString), executor)
        .onError(throwable -> {
              throwable.printStackTrace();
              stopLatch.countDown();
            }
        );
  }

  private static class NumberCrunchingTask implements Callable<Integer> {

    private static final Integer CRUNCHED_NUMBER = Integer.MAX_VALUE;

    @Override
    public Integer call() throws Exception {
      // Do number crunching
      Thread.sleep(100);
      return CRUNCHED_NUMBER;
    }
  }
}