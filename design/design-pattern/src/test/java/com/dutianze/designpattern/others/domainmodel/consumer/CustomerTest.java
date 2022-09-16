package com.dutianze.designpattern.others.domainmodel.consumer;

import static org.joda.money.CurrencyUnit.USD;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.dutianze.designpattern.others.domainmodel.product.Product;
import com.dutianze.designpattern.others.domainmodel.product.ProductRepository;
import com.dutianze.designpattern.others.domainmodel.product.ProductRepositoryImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/9/16
 */
class CustomerTest {

  public static final String H2_DB_URL = "jdbc:h2:~/test";

  public static final String CREATE_SCHEMA_SQL =
      "CREATE TABLE CUSTOMERS (name varchar primary key, money decimal);"
          + "CREATE TABLE PRODUCTS (name varchar primary key, price decimal, expiration_date date);"
          + "CREATE TABLE PURCHASES ("
          + "product_name varchar references PRODUCTS(name),"
          + "customer_name varchar references CUSTOMERS(name));";

  public static final String DELETE_SCHEMA_SQL =
      "DROP TABLE CUSTOMERS IF EXISTS;"
          + "DROP TABLE PURCHASES IF EXISTS;"
          + "DROP TABLE PRODUCTS IF EXISTS;";

  @Test
  void usage() {
    assertDoesNotThrow(() -> {

      // Create data source and create the customers, products and purchases tables
      final DataSource dataSource = createDataSource();
      deleteSchema(dataSource);
      createSchema(dataSource);

      // create customer
      CustomerRepository customerDao = new CustomerRepositoryImpl(dataSource);

      Customer tom =
          Customer.builder()
              .name("Tom")
              .money(Money.of(USD, 30))
              .customerDao(customerDao)
              .build();

      tom.save();

      // create products
      ProductRepository productDao = new ProductRepositoryImpl(dataSource);

      Product eggs =
          Product.builder()
              .name("Eggs")
              .price(Money.of(USD, 10.0))
              .expirationDate(LocalDate.now().plusDays(7))
              .productDao(productDao)
              .build();

      Product butter =
          Product.builder()
              .name("Butter")
              .price(Money.of(USD, 20.00))
              .expirationDate(LocalDate.now().plusDays(9))
              .productDao(productDao)
              .build();

      Product cheese =
          Product.builder()
              .name("Cheese")
              .price(Money.of(USD, 25.0))
              .expirationDate(LocalDate.now().plusDays(2))
              .productDao(productDao)
              .build();

      eggs.save();
      butter.save();
      cheese.save();

      // show money balance of customer after each purchase
      tom.showBalance();
      tom.showPurchases();

      // buy eggs
      tom.buyProduct(eggs);
      tom.showBalance();

      // buy butter
      tom.buyProduct(butter);
      tom.showBalance();

      // trying to buy cheese, but receive a refusal
      // because he didn't have enough money
      tom.buyProduct(cheese);
      tom.showBalance();

      // return butter and get money back
      tom.returnProduct(butter);
      tom.showBalance();

      // Tom can buy cheese now because he has enough money
      // and there is a discount on cheese because it expires in 2 days
      tom.buyProduct(cheese);

      tom.save();

      // show money balance and purchases after shopping
      tom.showBalance();
      tom.showPurchases();
    });
  }


  private static DataSource createDataSource() {
    JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setUrl(H2_DB_URL);
    return dataSource;
  }

  private static void deleteSchema(DataSource dataSource) throws SQLException {
    try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
      statement.execute(DELETE_SCHEMA_SQL);
    }
  }

  private static void createSchema(DataSource dataSource) throws SQLException {
    try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
      statement.execute(CREATE_SCHEMA_SQL);
    }
  }
}