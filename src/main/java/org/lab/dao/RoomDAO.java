package org.lab.dao;

import org.lab.model.Room;

import java.util.List;

public interface RoomDAO {
    List<Room> findAll();
}