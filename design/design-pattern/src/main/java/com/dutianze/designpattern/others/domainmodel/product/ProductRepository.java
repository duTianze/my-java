package com.dutianze.designpattern.others.domainmodel.product;

import java.sql.SQLException;
import java.util.Optional;

/**
 * @author dutianze
 * @date 2022/9/16
 */
public interface ProductRepository {

  Optional<Product> findByName(String name) throws SQLException;

  void save(Product product) throws SQLException;

  void update(Product product) throws SQLException;
}