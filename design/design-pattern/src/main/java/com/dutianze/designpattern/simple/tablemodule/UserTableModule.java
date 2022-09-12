package com.dutianze.designpattern.simple.tablemodule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/23
 */
@Slf4j
public class UserTableModule {

  public static final String CREATE_SCHEMA_SQL = """
      CREATE TABLE IF NOT EXISTS USERS (ID NUMBER, USERNAME VARCHAR(30) UNIQUE,PASSWORD VARCHAR(30))
      """;
  public static final String DELETE_SCHEMA_SQL = "DROP TABLE USERS IF EXISTS";
  private final DataSource dataSource;


  public UserTableModule(final DataSource userDataSource) {
    this.dataSource = userDataSource;
  }

  public int login(final String username, final String password) throws SQLException {
    String sql = "select count(*) from USERS where username=? and password=?";
    ResultSet resultSet = null;
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      int result = 0;
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        result = resultSet.getInt(1);
      }
      if (result == 1) {
        log.info("Login successfully!");
      } else {
        log.warn("Fail to login!");
      }
      return result;
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
    }
  }

  public int registerUser(final User user) throws SQLException {
    String sql = "insert into USERS (username, password) values (?,?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, user.getUsername());
      preparedStatement.setString(2, user.getPassword());
      int result = preparedStatement.executeUpdate();
      log.info("Register successfully!");
      return result;
    }
  }
}
