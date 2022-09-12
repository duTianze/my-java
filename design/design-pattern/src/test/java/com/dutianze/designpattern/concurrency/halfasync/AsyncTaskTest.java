package com.dutianze.designpattern.concurrency.halfasync;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

/**
 * @author dutianze
 * @date 2022/9/8
 */
@Slf4j
class AsyncTaskTest {

  private AsynchronousService service;
  private AsyncTask<Object> task;

  @BeforeEach
  public void setUp() {
    service = new AsynchronousService(new LinkedBlockingQueue<>());
    task = mock(AsyncTask.class);
  }

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      service.execute(new ArithmeticSumTask(300));
      service.execute(new ArithmeticSumTask(200));
      service.close();
    });
  }

  @Test
  void testPerfectExecution() throws Exception {
    final Object result = new Object();
    when(task.call()).thenReturn(result);
    service.execute(task);

    verify(task, timeout(2000)).onPostCall(eq(result));

    final InOrder inOrder = inOrder(task);
    inOrder.verify(task, times(1)).onPreCall();
    inOrder.verify(task, times(1)).call();
    inOrder.verify(task, times(1)).onPostCall(eq(result));

    verifyNoMoreInteractions(task);
  }

  @Test
  void testCallException() throws Exception {
    final IOException exception = new IOException();
    when(task.call()).thenThrow(exception);
    service.execute(task);

    verify(task, timeout(2000)).onError(eq(exception));

    final InOrder inOrder = inOrder(task);
    inOrder.verify(task, times(1)).onPreCall();
    inOrder.verify(task, times(1)).call();
    inOrder.verify(task, times(1)).onError(exception);

    verifyNoMoreInteractions(task);
  }

  @Test
  void testPreCallException() {
    final IllegalStateException exception = new IllegalStateException();
    doThrow(exception).when(task).onPreCall();
    service.execute(task);

    verify(task, timeout(2000)).onError(eq(exception));

    final InOrder inOrder = inOrder(task);
    inOrder.verify(task, times(1)).onPreCall();
    inOrder.verify(task, times(1)).onError(exception);

    verifyNoMoreInteractions(task);
  }

  static class ArithmeticSumTask implements AsyncTask<Long> {

    private final long numberOfElements;

    public ArithmeticSumTask(long numberOfElements) {
      this.numberOfElements = numberOfElements;
    }

    @Override
    public Long call() throws Exception {
      return ap(numberOfElements);
    }

    @Override
    public void onPreCall() {
      if (numberOfElements < 0) {
        throw new IllegalArgumentException("n is less than 0");
      }
    }

    @Override
    public void onPostCall(Long result) {
      log.info(result.toString());
    }

    @Override
    public void onError(Throwable throwable) {
      throw new IllegalStateException("Should not occur");
    }
  }

  private static long ap(long i) {
    try {
      Thread.sleep(i);
    } catch (InterruptedException e) {
      log.error("Exception caught.", e);
    }
    return i * (i + 1) / 2;
  }

}