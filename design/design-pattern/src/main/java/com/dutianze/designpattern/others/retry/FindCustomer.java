package com.dutianze.designpattern.others.retry;

import com.dutianze.designpattern.others.retry.exception.BusinessException;
import com.dutianze.designpattern.others.retry.retry.BusinessOperation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public final class FindCustomer implements BusinessOperation<String> {

    private final String customerId;
    private final Deque<BusinessException> errors;

    public FindCustomer(String customerId, BusinessException... errors) {
        this.customerId = customerId;
        this.errors = new ArrayDeque<>(List.of(errors));
    }

    @Override
    public String perform() throws BusinessException {
        if (!this.errors.isEmpty()) {
            throw this.errors.pop();
        }
        return this.customerId;
    }
}
