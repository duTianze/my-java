package com.dutianze.designpattern.simple.transactionscript.dao;

import com.dutianze.designpattern.simple.transactionscript.domain.Room;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author dutianze
 * @date 2022/8/20
 */
public interface RoomDao {

    Stream<Room> getAll() throws Exception;

    Optional<Room> getById(int id) throws Exception;

    Boolean add(Room room) throws Exception;

    Boolean update(Room room) throws Exception;

    Boolean delete(Room room) throws Exception;
}