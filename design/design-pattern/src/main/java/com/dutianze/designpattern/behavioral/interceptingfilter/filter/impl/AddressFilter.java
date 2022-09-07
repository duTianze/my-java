package com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl;

import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.Filter;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class AddressFilter implements Filter {

    @Override
    public void doFilter(Order order, StringBuilder result, FilterChain chain) {
        if (order.getAddress() == null || order.getAddress().isEmpty()) {
            result.append("Invalid address! ");
        }
        chain.doFilter(order, result, chain);
    }
}
