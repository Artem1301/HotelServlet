package org.lab.dao;

import org.lab.model.Booking;
import org.lab.util.DBUtil;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class BookingDAO {
    public void save(Booking booking) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO bookings (guests, room_class, check_in, check_out) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, booking.getGuests());
            stmt.setString(2, booking.getRoomClass());
            stmt.setDate(3, Date.valueOf(booking.getCheckIn()));
            stmt.setDate(4, Date.valueOf(booking.getCheckOut()));
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Booking> findAll() {
        List<Booking> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM bookings");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Booking(
                        rs.getInt("guests"),
                        rs.getString("room_class"),
                        rs.getString("check_in"),
                        rs.getString("check_out")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}