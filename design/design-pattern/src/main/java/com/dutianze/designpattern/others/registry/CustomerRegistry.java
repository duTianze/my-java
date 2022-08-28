package com.dutianze.designpattern.others.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dutianze
 * @date 2022/8/28
 */
public final class CustomerRegistry {

    private static final CustomerRegistry instance = new CustomerRegistry();

    public static CustomerRegistry getInstance() {
        return instance;
    }

    private final Map<String, Customer> customerMap;

    private CustomerRegistry() {
        customerMap = new ConcurrentHashMap<>();
    }

    public Customer addCustomer(Customer customer) {
        return customerMap.put(customer.getId(), customer);
    }

    public Customer getCustomer(String id) {
        return customerMap.get(id);
    }
}
