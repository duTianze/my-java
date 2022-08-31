package com.dutianze.designpattern.simple.transactionscript;

import com.dutianze.designpattern.simple.transactionscript.dao.RoomDao;
import com.dutianze.designpattern.simple.transactionscript.dao.impl.RoomDaoImpl;
import com.dutianze.designpattern.simple.transactionscript.domain.Room;
import com.dutianze.designpattern.simple.transactionscript.service.RoomService;
import com.dutianze.designpattern.simple.transactionscript.service.impl.RoomServiceImpl;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dutianze
 * @date 2022/8/21
 */
public class RoomServiceTest {

    private static final String H2_DB_URL = "jdbc:h2:~/test";
    public static final String CREATE_SCHEMA_SQL =
            """
                        CREATE TABLE PUBLIC.ROOMS (
                        ID INTEGER,
                        ROOM_TYPE VARCHAR_IGNORECASE(128),
                        PRICE INTEGER,
                        BOOKED VARCHAR_IGNORECASE(128)
                        );
                    """;
    public static final String DELETE_SCHEMA_SQL = "DROP TABLE ROOMS IF EXISTS";

    private RoomService service;
    private RoomDao dao;

    @BeforeEach
    public void setUp() throws Exception {
        final JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(H2_DB_URL);

        deleteSchema(dataSource);
        createSchema(dataSource);

        dao = new RoomDaoImpl(dataSource);
        addRooms(dao);
        service = new RoomServiceImpl(dao);
    }

    @Test
    void bookingRoomShouldChangeBookedStatusToTrue() throws Exception {
        service.bookRoom(1);
        dao.getById(1).ifPresent(room -> assertTrue(room.isBooked()));
    }

    @Test
    void bookingRoomWithInvalidIdShouldRaiseException() {
        assertThrows(Exception.class, () -> service.bookRoom(getNonExistingRoomId()));
    }

    @Test
    void bookingRoomAgainShouldRaiseException() {
        assertThrows(Exception.class, () -> {
            service.bookRoom(1);
            service.bookRoom(1);
        });
    }

    @Test
    void notBookingRoomShouldNotChangeBookedStatus() throws Exception {
        dao.getById(1).ifPresent(room -> assertFalse(room.isBooked()));
    }

    @Test
    void cancelRoomBookingShouldChangeBookedStatus() throws Exception {
        service.bookRoom(1);
        dao.getById(1).ifPresent(room -> assertTrue(room.isBooked()));

        service.cancelRoomBooking(1);
        dao.getById(1).ifPresent(room -> assertFalse(room.isBooked()));
    }

    @Test
    void cancelRoomBookingWithInvalidIdShouldRaiseException() {
        assertThrows(Exception.class, () -> service.cancelRoomBooking(getNonExistingRoomId()));
    }

    @Test
    void cancelRoomBookingForUnbookedRoomShouldRaiseException() {
        assertThrows(Exception.class, () -> service.cancelRoomBooking(1));
    }

    private static void addRooms(RoomDao hotelDao) throws Exception {
        for (Room room : generateSampleRooms()) {
            hotelDao.add(room);
        }
    }

    public static List<Room> generateSampleRooms() {
        final Room room1 = new Room(1, "Single", 50, false);
        final Room room2 = new Room(2, "Double", 80, false);
        final Room room3 = new Room(3, "Queen", 120, false);
        final Room room4 = new Room(4, "King", 150, false);
        final Room room5 = new Room(5, "Single", 50, false);
        final Room room6 = new Room(6, "Double", 80, false);
        return List.of(room1, room2, room3, room4, room5, room6);
    }

    private static void deleteSchema(DataSource dataSource) throws java.sql.SQLException {
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(DELETE_SCHEMA_SQL);
        }
    }

    private static void createSchema(DataSource dataSource) throws Exception {
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(CREATE_SCHEMA_SQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    private int getNonExistingRoomId() {
        return 999;
    }
}
