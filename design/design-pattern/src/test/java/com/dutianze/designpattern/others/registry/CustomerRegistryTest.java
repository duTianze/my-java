package com.dutianze.designpattern.others.registry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/28
 */
class CustomerRegistryTest {

  private static CustomerRegistry customerRegistry;

  @BeforeAll
  public static void setUp() {
    customerRegistry = CustomerRegistry.getInstance();
  }

  @Test
  public void shouldBeAbleToAddAndQueryCustomerObjectFromRegistry() {
    Customer john = new Customer("1", "john");
    Customer julia = new Customer("2", "julia");

    customerRegistry.addCustomer(john);
    customerRegistry.addCustomer(julia);

    Customer customerWithId1 = customerRegistry.getCustomer("1");
    assertNotNull(customerWithId1);
    assertEquals("1", customerWithId1.getId());
    assertEquals("john", customerWithId1.getName());

    Customer customerWithId2 = customerRegistry.getCustomer("2");
    assertNotNull(customerWithId2);
    assertEquals("2", customerWithId2.getId());
    assertEquals("julia", customerWithId2.getName());
  }

  @Test
  void shouldReturnNullWhenQueriedCustomerIsNotInRegistry() {
    Customer customerWithId5 = customerRegistry.getCustomer("5");
    assertNull(customerWithId5);
  }
}