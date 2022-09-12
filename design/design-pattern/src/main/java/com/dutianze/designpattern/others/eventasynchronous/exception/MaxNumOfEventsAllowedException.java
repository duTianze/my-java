package com.dutianze.designpattern.others.eventasynchronous.exception;

/**
 * @author dutianze
 * @date 2022/9/12
 */
public class MaxNumOfEventsAllowedException extends Exception {

  private static final long serialVersionUID = -8430876973516292695L;

  public MaxNumOfEventsAllowedException(String message) {
    super(message);
  }
}
