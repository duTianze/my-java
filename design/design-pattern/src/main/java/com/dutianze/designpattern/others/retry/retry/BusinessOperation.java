package com.dutianze.designpattern.others.retry.retry;

import com.dutianze.designpattern.others.retry.exception.BusinessException;

/**
 * @author dutianze
 * @date 2022/8/28
 */
@FunctionalInterface
public interface BusinessOperation<T> {

  T perform() throws BusinessException;
}
