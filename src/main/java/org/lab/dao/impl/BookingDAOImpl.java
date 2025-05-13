// BookingDAOImpl.java
package org.lab.dao.impl;

import org.lab.dao.BookingDAO;
import org.lab.model.Booking;
import org.lab.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    private final Connection connection;

    public BookingDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void create(Booking booking) {
        String query = "INSERT INTO bookings (user_id, first_name, middle_name, phone, capacity, room_class, start_date, end_date, status, room_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setString(2, booking.getFirstName());
            stmt.setString(3, booking.getMiddleName());
            stmt.setString(4, booking.getPhone());
            stmt.setInt(5, booking.getCapacity());
            stmt.setString(6, booking.getRoomClass());
            stmt.setDate(7, booking.getStartDate());
            stmt.setDate(8, booking.getEndDate());
            stmt.setString(9, booking.getStatus());
            stmt.setObject(10, booking.getRoomId(), java.sql.Types.INTEGER);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating booking", e);
        }
    }

    @Override
    public List<Booking> findByUserId(int userId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getString("phone"),
                        rs.getInt("capacity"),
                        rs.getString("room_class"),
                        rs.getInt("room_id") != 0 ? rs.getInt("room_id") : null,
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding bookings by user ID", e);
        }
        return bookings;
    }

    @Override
    public List<Booking> findAllPending() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE status = 'pending'";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bookings.add(new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getString("phone"),
                        rs.getInt("capacity"),
                        rs.getString("room_class"),
                        rs.getInt("room_id") != 0 ? rs.getInt("room_id") : null,
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding pending bookings", e);
        }
        return bookings;
    }

    @Override
    public Booking findById(int id) {
        String query = "SELECT * FROM bookings WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Booking(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getString("phone"),
                        rs.getInt("capacity"),
                        rs.getString("room_class"),
                        rs.getInt("room_id") != 0 ? rs.getInt("room_id") : null,
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding booking by ID", e);
        }
        return null;
    }

    @Override
    public void update(Booking booking) {
        String query = "UPDATE bookings SET user_id = ?, first_name = ?, middle_name = ?, phone = ?, capacity = ?, room_class = ?, start_date = ?, end_date = ?, status = ?, room_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setString(2, booking.getFirstName());
            stmt.setString(3, booking.getMiddleName());
            stmt.setString(4, booking.getPhone());
            stmt.setInt(5, booking.getCapacity());
            stmt.setString(6, booking.getRoomClass());
            stmt.setDate(7, booking.getStartDate());
            stmt.setDate(8, booking.getEndDate());
            stmt.setString(9, booking.getStatus());
            stmt.setObject(10, booking.getRoomId(), java.sql.Types.INTEGER);
            stmt.setInt(11, booking.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating booking", e);
        }
    }
}