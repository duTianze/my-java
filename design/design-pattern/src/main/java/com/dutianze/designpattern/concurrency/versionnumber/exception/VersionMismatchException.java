package com.dutianze.designpattern.concurrency.versionnumber.exception;

/**
 * @author dutianze
 * @date 2022/8/15
 */
public class VersionMismatchException extends Exception {

  public VersionMismatchException(String message) {
    super(message);
  }
}