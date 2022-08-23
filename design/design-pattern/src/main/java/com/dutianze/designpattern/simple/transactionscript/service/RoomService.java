package com.dutianze.designpattern.simple.transactionscript.service;

/**
 * @author dutianze
 * @date 2022/8/20
 */
public interface RoomService {

    void bookRoom(int roomNumber) throws Exception;

    void cancelRoomBooking(int roomNumber) throws Exception;
}