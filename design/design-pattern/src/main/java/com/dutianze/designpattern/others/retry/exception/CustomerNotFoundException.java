package com.dutianze.designpattern.others.retry.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class CustomerNotFoundException extends BusinessException {

  @Serial
  private static final long serialVersionUID = 2469500863700182147L;

  public CustomerNotFoundException(String message) {
    super(message);
  }
}
