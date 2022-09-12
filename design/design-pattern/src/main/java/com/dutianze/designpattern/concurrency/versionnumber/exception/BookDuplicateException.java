package com.dutianze.designpattern.concurrency.versionnumber.exception;

/**
 * @author dutianze
 * @date 2022/8/15
 */
public class BookDuplicateException extends Exception {

  public BookDuplicateException(String message) {
    super(message);
  }
}