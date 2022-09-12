package com.dutianze.designpattern.behavioral.interceptingfilter;

import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;


/**
 * <h2 id="real-world-examples">Real world examples</h2>
 * <ul>
 * <li><a href="https://tomcat.apache.org/tomcat-8.0-doc/servletapi/javax/servlet/FilterChain.html">javax.servlet.FilterChain</a> and <a href="https://tomcat.apache.org/tomcat-8.0-doc/servletapi/javax/servlet/Filter.html">javax.servlet.Filter</a></li>
 * <li><a href="https://struts.apache.org/core-developers/interceptors.html">Struts 2 - Interceptors</a></li>
 * </ul>
 *
 * @author dutianze
 * @date 2022/9/8
 */
public interface Filter {

  void doFilter(Order order, StringBuilder result, FilterChain chain);
}
