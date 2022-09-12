package com.dutianze.designpattern.others.eventasynchronous.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class InvalidOperationException extends Exception {

  @Serial
  private static final long serialVersionUID = -6191545255213410803L;

  public InvalidOperationException(String message) {
    super(message);
  }
}
