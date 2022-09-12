package com.dutianze.designpattern.concurrency.lockableobject.domain.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/9/6
 */
public class LockingException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 8556381044865867037L;

  public LockingException(String message) {
    super(message);
  }
}