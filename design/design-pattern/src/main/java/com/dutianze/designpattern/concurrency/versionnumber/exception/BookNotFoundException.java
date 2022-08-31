package com.dutianze.designpattern.concurrency.versionnumber.exception;

/**
 * @author dutianze
 * @date 2022/8/15
 */
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }
}