package com.dutianze.designpattern.others.retry.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class DatabaseNotAvailableException extends BusinessException {

  @Serial
  private static final long serialVersionUID = -1411520395295319526L;

  public DatabaseNotAvailableException(String message) {
    super(message);
  }
}
