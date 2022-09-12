package com.dutianze.designpattern.simple.transactionscript.service.impl;

import com.dutianze.designpattern.simple.transactionscript.dao.RoomDao;
import com.dutianze.designpattern.simple.transactionscript.domain.Room;
import com.dutianze.designpattern.simple.transactionscript.service.RoomService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dutianze
 * @date 2022/8/20
 */
@Slf4j
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

  private final RoomDao hotelDao;

  @Override
  public void bookRoom(int roomNumber) throws Exception {
    Optional<Room> roomOptional = hotelDao.getById(roomNumber);
    if (roomOptional.isEmpty()) {
      throw new Exception("Room number: " + roomNumber + " does not exist");
    }
    if (roomOptional.get().isBooked()) {
      throw new Exception("Room already booked!");
    }

    Room room = roomOptional.get();
    room.book();
    hotelDao.update(room);
  }

  @Override
  public void cancelRoomBooking(int roomNumber) throws Exception {
    Optional<Room> roomOptional = hotelDao.getById(roomNumber);
    if (roomOptional.isEmpty()) {
      throw new Exception("Room number: " + roomNumber + " does not exist");
    }
    if (!roomOptional.get().isBooked()) {
      throw new Exception("No booking for the room exists");
    }

    Room room = roomOptional.get();
    room.cancelBook();
    int refundAmount = room.getPrice();
    hotelDao.update(room);

    log.info("Booking cancelled for room number: " + roomNumber);
    log.info(refundAmount + " is refunded");
  }
}