package com.dutianze.designpattern.others.eventasynchronous.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class LongRunningEventException extends Exception {

  @Serial
  private static final long serialVersionUID = -483423544320148809L;

  public LongRunningEventException(String message) {
    super(message);
  }
}
