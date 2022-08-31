package com.dutianze.designpattern.simple.transactionscript;

import com.dutianze.designpattern.simple.transactionscript.dao.RoomDao;
import com.dutianze.designpattern.simple.transactionscript.dao.impl.RoomDaoImpl;
import com.dutianze.designpattern.simple.transactionscript.domain.Room;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.*;

/**
 * @author dutianze
 * @date 2022/8/21
 */
class RoomDaoTest {

    private static final String DB_URL = "jdbc:h2:~/test";
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
    private final Room existingRoom = new Room(1, "Single", 50, false);

    private RoomDao dao;

    @BeforeEach
    public void createSchema() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_SCHEMA_SQL);
            statement.execute(CREATE_SCHEMA_SQL);
        }
    }

    @AfterEach
    public void deleteSchema() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_SCHEMA_SQL);
        }
    }

    @Nested
    public class ConnectionSuccess {

        @BeforeEach
        public void setUp() throws Exception {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL(DB_URL);
            dao = new RoomDaoImpl(dataSource);
            Boolean result = dao.add(existingRoom);
            Assertions.assertTrue(result);
        }

        @Nested
        public class NonExistingRoom {

            @Test
            void addingShouldResultInSuccess() throws Exception {
                try (Stream<Room> allRooms = dao.getAll()) {
                    assumeTrue(allRooms.count() == 1);
                }

                final Room nonExistingRoom = new Room(2, "Double", 80, false);
                Boolean result = dao.add(nonExistingRoom);
                Assertions.assertTrue(result);

                assertRoomCountIs(2);
                dao.getById(nonExistingRoom.getId())
                   .ifPresent(room -> assertEquals(nonExistingRoom, room));
            }

            @Test
            void deletionShouldBeFailureAndNotAffectExistingRooms() throws Exception {
                final Room nonExistingRoom = new Room(2, "Double", 80, false);
                Boolean result = dao.delete(nonExistingRoom);

                Assertions.assertFalse(result);
                assertRoomCountIs(1);
            }

            @Test
            void updateShouldBeFailureAndNotAffectExistingRooms() throws Exception {
                final int nonExistingId = getNonExistingRoomId();
                final String newRoomType = "Double";
                final int newPrice = 80;
                final Room room = new Room(nonExistingId, newRoomType, newPrice, false);

                Boolean result = dao.update(room);

                Assertions.assertFalse(result);
                assertFalse(dao.getById(nonExistingId).isPresent());
            }

            @Test
            void retrieveShouldReturnNoRoom() throws Exception {
                assertFalse(dao.getById(getNonExistingRoomId()).isPresent());
            }
        }

        @Nested
        public class ExistingRoom {

            @Test
            void addingShouldResultInFailureAndNotAffectExistingRooms() throws Exception {
                Boolean result = dao.add(existingRoom);

                Assertions.assertFalse(result);
                assertRoomCountIs(1);
                dao.getById(existingRoom.getId())
                   .ifPresent(room -> assertEquals(existingRoom, room));
            }

            @Test
            void deletionShouldBeSuccessAndRoomShouldBeNonAccessible() throws Exception {
                Boolean result = dao.delete(existingRoom);

                Assertions.assertTrue(result);
                assertRoomCountIs(0);
                assertTrue(dao.getById(existingRoom.getId()).isEmpty());
            }

            @Test
            void updateShouldBeSuccessAndAccessingTheSameRoomShouldReturnUpdatedInformation() throws Exception {
                final String newRoomType = "Double";
                final int newPrice = 80;
                final boolean newBookingStatus = false;
                final Room Room = new Room(existingRoom.getId(), newRoomType, newPrice, newBookingStatus);

                Boolean result = dao.update(Room);

                Assertions.assertTrue(result);

                dao.getById(existingRoom.getId())
                   .ifPresent(room -> {
                       assertEquals(newRoomType, room.getRoomType());
                       assertEquals(newPrice, room.getPrice());
                       assertEquals(newBookingStatus, room.isBooked());
                   });
            }
        }
    }

    @Nested
    public class ConnectivityIssue {

        private static final String EXCEPTION_CAUSE = "Connection not available";

        @BeforeEach
        public void setUp() throws SQLException {
            dao = new RoomDaoImpl(mockedDatasource());
        }

        @Test
        void addingARoomFailsWithExceptionAsFeedbackToClient() {
            assertThrows(Exception.class, () -> dao.add(new Room(2, "Double", 80, false)));
        }

        @Test
        void deletingARoomFailsWithExceptionAsFeedbackToTheClient() {
            assertThrows(Exception.class, () -> dao.delete(existingRoom));
        }

        @Test
        void updatingARoomFailsWithFeedbackToTheClient() {
            final String newRoomType = "Double";
            final int newPrice = 80;
            final boolean newBookingStatus = false;
            assertThrows(Exception.class,
                         () -> dao.update(new Room(existingRoom.getId(), newRoomType, newPrice, newBookingStatus)));
        }

        @Test
        void retrievingARoomByIdFailsWithExceptionAsFeedbackToClient() {
            assertThrows(Exception.class, () -> dao.getById(existingRoom.getId()));
        }

        @Test
        void retrievingAllRoomsFailsWithExceptionAsFeedbackToClient() {
            assertThrows(Exception.class, () -> dao.getAll());
        }

        private DataSource mockedDatasource() throws SQLException {
            DataSource mockedDataSource = mock(DataSource.class);
            Connection mockedConnection = mock(Connection.class);
            SQLException exception = new SQLException(EXCEPTION_CAUSE);
            doThrow(exception).when(mockedConnection).prepareStatement(Mockito.anyString());
            doReturn(mockedConnection).when(mockedDataSource).getConnection();
            return mockedDataSource;
        }
    }

    private void assertRoomCountIs(int count) throws Exception {
        try (Stream<Room> allRooms = dao.getAll()) {
            assertEquals(count, allRooms.count());
        }
    }

    private int getNonExistingRoomId() {
        return 999;
    }
}