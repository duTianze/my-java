package com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl;

import com.dutianze.designpattern.behavioral.interceptingfilter.Filter;
import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class NameFilter implements Filter {

  @Override
  public void doFilter(Order order, StringBuilder result, FilterChain chain) {
    String name = order.getName();
    if (name == null || name.isEmpty() || name.matches(".*[^\\w|\\s]+.*")) {
      result.append("Invalid name! ");
    }
    chain.doFilter(order, result, chain);
  }
}
