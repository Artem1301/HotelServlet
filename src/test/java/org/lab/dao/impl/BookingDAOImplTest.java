package org.lab.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lab.model.Booking;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BookingDAOImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private BookingDAOImpl bookingDAO;

    @BeforeEach
    void setUp() throws Exception {
        Field connectionField = BookingDAOImpl.class.getDeclaredField("connection");
        connectionField.setAccessible(true);
        connectionField.set(bookingDAO, connection);

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(preparedStatement.executeUpdate()).thenReturn(1);
    }

    @Test
    void testFindByIdNotFound() throws SQLException {
        int bookingId = 999;
        when(resultSet.next()).thenReturn(false); // Запис не знайдено

        Booking booking = bookingDAO.findById(bookingId);

        assertNull(booking);
    }

    @Test
    void testFindAllPendingEmpty() throws SQLException {
        when(resultSet.next()).thenReturn(false); // Немає записів

        List<Booking> pendingBookings = bookingDAO.findAllPending();

        assertNotNull(pendingBookings);
        assertTrue(pendingBookings.isEmpty());
    }

    @Test
    void testCreateBookingSQLException() throws Exception {
        Booking booking = new Booking(1, "John", "Doe", "123456789", 2, "Standard", Date.valueOf("2025-05-14"), Date.valueOf("2025-05-16"));
        when(preparedStatement.executeUpdate()).thenThrow(new SQLException("Database error"));

        assertThrows(RuntimeException.class, () -> bookingDAO.create(booking));
    }

    @Test
    void testUpdateBookingSQLException() throws Exception {
        Booking booking = new Booking(1, 1, "John", "Doe", "123456789", 2, "Standard", 101, Date.valueOf("2025-05-14"), Date.valueOf("2025-05-16"), "assigned");
        when(preparedStatement.executeUpdate()).thenThrow(new SQLException("Database error"));

        assertThrows(RuntimeException.class, () -> bookingDAO.update(booking));
    }
}