package com.dutianze.designpattern.simple.transactionscript.dao.impl;

import com.dutianze.designpattern.simple.transactionscript.dao.RoomDao;
import com.dutianze.designpattern.simple.transactionscript.domain.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/20
 */
@Slf4j
@RequiredArgsConstructor
public class RoomDaoImpl implements RoomDao {

  private final DataSource dataSource;

  @Override
  public Stream<Room> getAll() throws Exception {
    try {
      Connection connection = dataSource.getConnection();
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM ROOMS");
      ResultSet resultSet = statement.executeQuery();
      return StreamSupport.stream(new Spliterators.AbstractSpliterator<Room>(Long.MAX_VALUE,
          Spliterator.ORDERED) {
        @Override
        public boolean tryAdvance(Consumer<? super Room> action) {
          try {
            if (!resultSet.next()) {
              return false;
            }
            action.accept(deserialize(resultSet));
            return true;
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        }
      }, false).onClose(() -> {
        try {
          mutedClose(connection, statement, resultSet);
        } catch (Exception e) {
          log.error(e.getMessage());
        }
      });
    } catch (Exception e) {
      throw new Exception(e.getMessage(), e);
    }
  }

  @Override
  public Optional<Room> getById(int id) throws Exception {
    ResultSet resultSet = null;
    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "SELECT * FROM ROOMS WHERE ID = ?")) {
      statement.setInt(1, id);
      resultSet = statement.executeQuery();
      if (!resultSet.next()) {
        return Optional.empty();
      }
      return Optional.of(deserialize(resultSet));
    } catch (Exception e) {
      throw new Exception(e.getMessage(), e);
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
    }
  }

  @Override
  public Boolean add(Room room) throws Exception {
    if (getById(room.getId()).isPresent()) {
      return false;
    }

    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "INSERT INTO ROOMS VALUES (?,?,?,?)")) {
      statement.setInt(1, room.getId());
      statement.setString(2, room.getRoomType());
      statement.setInt(3, room.getPrice());
      statement.setBoolean(4, room.isBooked());
      statement.execute();
      return true;
    } catch (Exception e) {
      throw new Exception(e.getMessage(), e);
    }
  }

  @Override
  public Boolean update(Room room) throws Exception {
    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement =
            connection.prepareStatement("UPDATE ROOMS SET ROOM_TYPE = ?, PRICE = ?, BOOKED = ?"
                + " WHERE ID = ?")) {
      statement.setString(1, room.getRoomType());
      statement.setInt(2, room.getPrice());
      statement.setBoolean(3, room.isBooked());
      statement.setInt(4, room.getId());
      return statement.executeUpdate() > 0;
    } catch (Exception e) {
      throw new Exception(e.getMessage(), e);
    }
  }

  @Override
  public Boolean delete(Room room) throws Exception {
    try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "DELETE FROM ROOMS WHERE ID = ?")) {
      statement.setInt(1, room.getId());
      return statement.executeUpdate() > 0;
    } catch (Exception e) {
      throw new Exception(e.getMessage(), e);
    }
  }

  private Room deserialize(ResultSet resultSet) throws Exception {
    return new Room(resultSet.getInt("ID"),
        resultSet.getString("ROOM_TYPE"),
        resultSet.getInt("PRICE"),
        resultSet.getBoolean("BOOKED"));
  }

  private void mutedClose(Connection connection, PreparedStatement statement, ResultSet resultSet)
      throws Exception {
    try {
      resultSet.close();
      statement.close();
      connection.close();
    } catch (Exception e) {
      throw new Exception(e.getMessage(), e);
    }
  }
}
