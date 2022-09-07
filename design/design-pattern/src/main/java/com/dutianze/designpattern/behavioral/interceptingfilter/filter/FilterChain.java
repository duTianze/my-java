package com.dutianze.designpattern.behavioral.interceptingfilter.filter;

import com.dutianze.designpattern.behavioral.interceptingfilter.Filter;
import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dutianze
 * @date 2022/9/8
 */
public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();
    int index = 0;

    public FilterChain add(Filter f) {
        filters.add(f);
        return this;
    }

    @Override
    public void doFilter(Order order, StringBuilder result, FilterChain chain) {
        if (index == filters.size()) {
            return;
        }
        Filter f = filters.get(index);
        index++;

        f.doFilter(order, result, this);
    }
}
