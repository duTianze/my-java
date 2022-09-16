package com.dutianze.designpattern.others.domainmodel.product;

import static org.joda.money.CurrencyUnit.USD;

import java.sql.Connection;
import java.sql.Date;
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
public class ProductRepositoryImpl implements ProductRepository {

  private final DataSource dataSource;

  public ProductRepositoryImpl(final DataSource userDataSource) {
    this.dataSource = userDataSource;
  }

  @Override
  public Optional<Product> findByName(String name) throws SQLException {
    String sql = "select * from PRODUCTS where name = ?;";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, name);

      ResultSet rs = preparedStatement.executeQuery();

      if (rs.next()) {
        return Optional.of(
            Product.builder()
                .name(rs.getString("name"))
                .price(Money.of(USD, rs.getBigDecimal("price")))
                .expirationDate(rs.getDate("expiration_date").toLocalDate())
                .productDao(this)
                .build());
      } else {
        return Optional.empty();
      }
    }
  }

  @Override
  public void save(Product product) throws SQLException {
    String sql = "insert into PRODUCTS (name, price, expiration_date) values (?, ?, ?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, product.getName());
      preparedStatement.setBigDecimal(2, product.getPrice().getAmount());
      preparedStatement.setDate(3, Date.valueOf(product.getExpirationDate()));
      preparedStatement.executeUpdate();
    }
  }

  @Override
  public void update(Product product) throws SQLException {
    String sql = "update PRODUCTS set price = ?, expiration_date = ? where name = ?;";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setBigDecimal(1, product.getPrice().getAmount());
      preparedStatement.setDate(2, Date.valueOf(product.getExpirationDate()));
      preparedStatement.setString(3, product.getName());
      preparedStatement.executeUpdate();
    }
  }
}
