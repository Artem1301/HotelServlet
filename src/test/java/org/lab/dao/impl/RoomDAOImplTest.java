package org.lab.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lab.model.Room;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class RoomDAOImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private RoomDAOImpl roomDAO;

    @BeforeEach
    void setUp() throws Exception {
        Field connectionField = RoomDAOImpl.class.getDeclaredField("connection");
        connectionField.setAccessible(true);
        connectionField.set(roomDAO, connection);

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    void testFindAllEmpty() throws SQLException {
        when(resultSet.next()).thenReturn(false); // Немає записів

        List<Room> rooms = roomDAO.findAll();

        assertNotNull(rooms);
        assertTrue(rooms.isEmpty());
    }

    @Test
    void testFindAllSQLException() throws Exception {
        when(preparedStatement.executeQuery()).thenThrow(new SQLException("Database error"));

        assertThrows(RuntimeException.class, () -> roomDAO.findAll());
    }
}