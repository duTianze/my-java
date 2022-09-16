package com.dutianze.designpattern.others.domainmodel.consumer;

import com.dutianze.designpattern.others.domainmodel.product.Product;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/9/16
 */
public interface CustomerRepository {

  Optional<Customer> findByName(String name) throws SQLException;

  void update(Customer customer) throws SQLException;

  void save(Customer customer) throws SQLException;

  void addProduct(Product product, Customer customer) throws SQLException;

  void deleteProduct(Product product, Customer customer) throws SQLException;
}
