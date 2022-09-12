package com.dutianze.designpattern.simple.tablemodule;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author dutianze
 * @date 2022/8/23
 */
class UserTableModuleTest {

  private static final String DB_URL = "jdbc:h2:~/test";

  @BeforeEach
  void setUp() throws SQLException {
    try (Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement()) {
      statement.execute(UserTableModule.DELETE_SCHEMA_SQL);
      statement.execute(UserTableModule.CREATE_SCHEMA_SQL);
    }
  }

  @AfterEach
  void tearDown() throws SQLException {
    try (Connection connection = DriverManager.getConnection(DB_URL);
        Statement statement = connection.createStatement()) {
      statement.execute(UserTableModule.DELETE_SCHEMA_SQL);
    }
  }

  @Test
  void usage() {
    assertDoesNotThrow(() -> {
      final DataSource dataSource = createDataSource();
      UserTableModule userTableModule = new UserTableModule(dataSource);

      // Initialize two users.
      User user1 = new User(1, "123456", "123456");
      User user2 = new User(2, "test", "password");

      // Login and register using the instance of userTableModule.
      userTableModule.registerUser(user1);
      userTableModule.login(user1.getUsername(), user1.getPassword());
      userTableModule.login(user2.getUsername(), user2.getPassword());
      userTableModule.registerUser(user2);
      userTableModule.login(user2.getUsername(), user2.getPassword());
    });
  }

  @Test
  void loginShouldFail() throws SQLException {
    DataSource dataSource = createDataSource();
    UserTableModule userTableModule = new UserTableModule(dataSource);
    User user = new User(1, "123456", "123456");
    assertEquals(0, userTableModule.login(user.getUsername(),
        user.getPassword()));
  }

  @Test
  void loginShouldSucceed() throws SQLException {
    DataSource dataSource = createDataSource();
    UserTableModule userTableModule = new UserTableModule(dataSource);
    User user = new User(1, "123456", "123456");
    userTableModule.registerUser(user);
    assertEquals(1, userTableModule.login(user.getUsername(),
        user.getPassword()));
  }

  @Test
  void registerShouldFail() throws SQLException {
    DataSource dataSource = createDataSource();
    UserTableModule userTableModule = new UserTableModule(dataSource);
    User user = new User(1, "123456", "123456");
    userTableModule.registerUser(user);
    assertThrows(SQLException.class, () -> userTableModule.registerUser(user));
  }

  @Test
  void registerShouldSucceed() throws SQLException {
    DataSource dataSource = createDataSource();
    UserTableModule userTableModule = new UserTableModule(dataSource);
    User user = new User(1, "123456", "123456");
    assertEquals(1, userTableModule.registerUser(user));
  }

  private DataSource createDataSource() {
    JdbcDataSource dataSource = new JdbcDataSource();
    dataSource.setURL(DB_URL);
    return dataSource;
  }
}