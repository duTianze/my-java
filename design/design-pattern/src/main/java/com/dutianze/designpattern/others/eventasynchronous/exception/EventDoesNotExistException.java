package com.dutianze.designpattern.others.eventasynchronous.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class EventDoesNotExistException extends Exception {

  @Serial
  private static final long serialVersionUID = -8429277899275797365L;

  public EventDoesNotExistException(String message) {
    super(message);
  }
}
