package com.dutianze.designpattern.others.retry.exception;

import java.io.Serial;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public class BusinessException extends Exception {

    @Serial
    private static final long serialVersionUID = -5080582747884096475L;

    public BusinessException(String message) {
        super(message);
    }
}
