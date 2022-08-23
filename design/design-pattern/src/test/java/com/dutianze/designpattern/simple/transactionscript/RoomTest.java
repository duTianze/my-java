package com.dutianze.designpattern.simple.transactionscript;

import com.dutianze.designpattern.simple.transactionscript.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author dutianze
 * @date 2022/8/21
 */
public class RoomTest {

    private static final int ID = 1;
    private static final String ROOM_TYPE = "Single";
    private static final int PRICE = 50;
    private static final boolean BOOKED = false;

    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room(ID, ROOM_TYPE, PRICE, BOOKED);
    }

    @Test
    void getAndSetId() {
        final int newId = 2;
        room.setId(newId);

        assertEquals(newId, room.getId());
    }

    @Test
    void getAndSetRoomType() {
        final String newRoomType = "Double";
        room.setRoomType(newRoomType);

        assertEquals(newRoomType, room.getRoomType());
    }

    @Test
    void getAndSetPrice() {
        final int newPrice = 60;
        room.setPrice(newPrice);

        assertEquals(newPrice, room.getPrice());
    }

    @Test
    void notEqualWithDifferentId() {
        final int newId = 2;
        final Room otherRoom = new Room(newId, ROOM_TYPE, PRICE, BOOKED);

        assertNotEquals(room, otherRoom);
        assertNotEquals(room.hashCode(), otherRoom.hashCode());
    }

    @Test
    void equalsWithSameObjectValues() {
        final Room otherRoom = new Room(ID, ROOM_TYPE, PRICE, BOOKED);

        assertEquals(room, otherRoom);
        assertEquals(room.hashCode(), otherRoom.hashCode());
    }

    @Test
    void equalsWithSameObjects() {
        assertEquals(room, room);
        assertEquals(room.hashCode(), room.hashCode());
    }

    @Test
    void testToString() {
        assertEquals(String.format("Room(id=%s, roomType=%s, price=%s, booked=%s)",
                                   room.getId(), room.getRoomType(), room.getPrice(), room.isBooked()),
                     room.toString());
    }
}
