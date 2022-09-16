package com.dutianze.designpattern.others.domainmodel.consumer;

import static org.joda.money.CurrencyUnit.USD;

import com.dutianze.designpattern.others.domainmodel.product.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.sql.DataSource;
import org.joda.money.Money;

/**
 * @author dutianze
 * @date 2022/9/16
 */
public class CustomerRepositoryImpl implements CustomerRepository {

  private final DataSource dataSource;

  public CustomerRepositoryImpl(final DataSource userDataSource) {
    this.dataSource = userDataSource;
  }

  @Override
  public Optional<Customer> findByName(String name) throws SQLException {
    String sql = "select * from CUSTOMERS where name = ?;";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, name);

      ResultSet rs = preparedStatement.executeQuery();

      if (rs.next()) {
        return Optional.of(
            Customer.builder()
                .name(rs.getString("name"))
                .money(Money.of(USD, rs.getBigDecimal("money")))
                .customerDao(this)
                .build());
      } else {
        return Optional.empty();
      }
    }
  }

  @Override
  public void update(Customer customer) throws SQLException {
    String sql = "update CUSTOMERS set money = ? where name = ?;";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setBigDecimal(1, customer.getMoney().getAmount());
      preparedStatement.setString(2, customer.getName());
      preparedStatement.executeUpdate();
    }
  }

  @Override
  public void save(Customer customer) throws SQLException {
    String sql = "insert into CUSTOMERS (name, money) values (?, ?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, customer.getName());
      preparedStatement.setBigDecimal(2, customer.getMoney().getAmount());
      preparedStatement.executeUpdate();
    }
  }

  @Override
  public void addProduct(Product product, Customer customer) throws SQLException {
    String sql = "insert into PURCHASES (product_name, customer_name) values (?,?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, product.getName());
      preparedStatement.setString(2, customer.getName());
      preparedStatement.executeUpdate();
    }
  }

  @Override
  public void deleteProduct(Product product, Customer customer) throws SQLException {
    String sql = "delete from PURCHASES where product_name = ? and customer_name = ?";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, product.getName());
      preparedStatement.setString(2, customer.getName());
      preparedStatement.executeUpdate();
    }
  }
}
