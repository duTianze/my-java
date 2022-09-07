package com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl;

import com.dutianze.designpattern.behavioral.interceptingfilter.Filter;
import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class DepositFilter implements Filter {

    @Override
    public void doFilter(Order order, StringBuilder result, FilterChain chain) {
        String depositNumber = order.getDepositNumber();
        if (depositNumber == null || depositNumber.isEmpty()) {
            result.append("Invalid deposit number! ");
        }
        chain.doFilter(order, result, chain);
    }
}
