package com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl;

import com.dutianze.designpattern.behavioral.interceptingfilter.Filter;
import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class ContactFilter implements Filter {

  @Override
  public void doFilter(Order order, StringBuilder result, FilterChain chain) {
    String contactNumber = order.getContactNumber();
    if (contactNumber == null || contactNumber.matches(".*\\D+.*")
        || contactNumber.length() != 11) {
      result.append("Invalid contact number! ");
    }
    chain.doFilter(order, result, chain);
  }
}
