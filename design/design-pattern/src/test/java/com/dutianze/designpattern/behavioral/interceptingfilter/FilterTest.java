package com.dutianze.designpattern.behavioral.interceptingfilter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.dutianze.designpattern.behavioral.interceptingfilter.data.Order;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.FilterChain;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl.AddressFilter;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl.ContactFilter;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl.DepositFilter;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl.NameFilter;
import com.dutianze.designpattern.behavioral.interceptingfilter.filter.impl.OrderFilter;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author dutianze
 * @date 2022/9/8
 */
class FilterTest {

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      FilterChain filterChain = new FilterChain();
      filterChain.add(new NameFilter());
      filterChain.add(new ContactFilter());
      filterChain.add(new AddressFilter());
      filterChain.add(new DepositFilter());
      filterChain.add(new OrderFilter());

      StringBuilder result = new StringBuilder();
      filterChain.doFilter(WRONG_DEPOSIT, result, filterChain);
      System.out.println(result);
    });
  }

  private static final Order PERFECT_ORDER =
      new Order("name", "12345678901", "addr", "dep", "order");
  private static final Order WRONG_ORDER = new Order("name", "12345678901", "addr", "dep", "");
  private static final Order WRONG_DEPOSIT = new Order("name", "12345678901", "addr", "", "order");
  private static final Order WRONG_ADDRESS = new Order("name", "12345678901", "", "dep", "order");
  private static final Order WRONG_CONTACT = new Order("name", "", "addr", "dep", "order");
  private static final Order WRONG_NAME = new Order("", "12345678901", "addr", "dep", "order");

  static List<Object[]> getTestData() {
    return List.of(
        new Object[]{new FilterChain().add(new NameFilter()), PERFECT_ORDER, ""},
        new Object[]{new FilterChain().add(new NameFilter()), WRONG_NAME, "Invalid name!"},
        new Object[]{new FilterChain().add(new NameFilter()), WRONG_CONTACT, ""},
        new Object[]{new FilterChain().add(new NameFilter()), WRONG_ADDRESS, ""},
        new Object[]{new FilterChain().add(new NameFilter()), WRONG_DEPOSIT, ""},
        new Object[]{new FilterChain().add(new NameFilter()), WRONG_ORDER, ""},

        new Object[]{new FilterChain().add(new ContactFilter()), PERFECT_ORDER, ""},
        new Object[]{new FilterChain().add(new ContactFilter()), WRONG_NAME, ""},
        new Object[]{new FilterChain().add(new ContactFilter()), WRONG_CONTACT,
            "Invalid contact number!"},
        new Object[]{new FilterChain().add(new ContactFilter()), WRONG_ADDRESS, ""},
        new Object[]{new FilterChain().add(new ContactFilter()), WRONG_DEPOSIT, ""},
        new Object[]{new FilterChain().add(new ContactFilter()), WRONG_ORDER, ""},

        new Object[]{new FilterChain().add(new AddressFilter()), PERFECT_ORDER, ""},
        new Object[]{new FilterChain().add(new AddressFilter()), WRONG_NAME, ""},
        new Object[]{new FilterChain().add(new AddressFilter()), WRONG_CONTACT, ""},
        new Object[]{new FilterChain().add(new AddressFilter()), WRONG_ADDRESS, "Invalid address!"},
        new Object[]{new FilterChain().add(new AddressFilter()), WRONG_DEPOSIT, ""},
        new Object[]{new FilterChain().add(new AddressFilter()), WRONG_ORDER, ""},

        new Object[]{new FilterChain().add(new DepositFilter()), PERFECT_ORDER, ""},
        new Object[]{new FilterChain().add(new DepositFilter()), WRONG_NAME, ""},
        new Object[]{new FilterChain().add(new DepositFilter()), WRONG_CONTACT, ""},
        new Object[]{new FilterChain().add(new DepositFilter()), WRONG_ADDRESS, ""},
        new Object[]{new FilterChain().add(new DepositFilter()), WRONG_DEPOSIT,
            "Invalid deposit number!"},
        new Object[]{new FilterChain().add(new DepositFilter()), WRONG_ORDER, ""},

        new Object[]{new FilterChain().add(new OrderFilter()), PERFECT_ORDER, ""},
        new Object[]{new FilterChain().add(new OrderFilter()), WRONG_NAME, ""},
        new Object[]{new FilterChain().add(new OrderFilter()), WRONG_CONTACT, ""},
        new Object[]{new FilterChain().add(new OrderFilter()), WRONG_ADDRESS, ""},
        new Object[]{new FilterChain().add(new OrderFilter()), WRONG_DEPOSIT, ""},
        new Object[]{new FilterChain().add(new OrderFilter()), WRONG_ORDER, "Invalid order!"}
    );
  }

  @ParameterizedTest
  @MethodSource("getTestData")
  public void testExecute(FilterChain chain, Order order, String expectedResult) {
    StringBuilder result = new StringBuilder();
    chain.doFilter(order, result, chain);
    System.out.println(result);

    assertNotNull(result);
    assertEquals(expectedResult, result.toString().trim());
  }
}