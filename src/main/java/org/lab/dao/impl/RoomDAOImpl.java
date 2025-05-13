package org.lab.dao.impl;

import org.lab.dao.RoomDAO;
import org.lab.model.Room;
import org.lab.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private final Connection connection;

    public RoomDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM rooms";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("capacity"),
                        rs.getString("room_class")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding rooms", e);
        }
        return rooms;
    }
}