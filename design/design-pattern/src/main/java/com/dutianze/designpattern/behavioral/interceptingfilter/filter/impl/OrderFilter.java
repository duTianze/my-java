package com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl;

import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.Filter;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class OrderFilter implements Filter {

    @Override
    public void doFilter(Order order, StringBuilder result, FilterChain chain) {
        String orderItem = order.getOrderItem();
        if (orderItem == null || orderItem.isEmpty()) {
            result.append("Invalid order! ");
        }
        chain.doFilter(order, result, chain);
    }
}
