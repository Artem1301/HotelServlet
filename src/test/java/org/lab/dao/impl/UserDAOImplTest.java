package org.lab.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lab.model.User;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserDAOImplTest {

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    @InjectMocks
    private UserDAOImpl userDAO;

    @BeforeEach
    void setUp() throws Exception {
        Field connectionField = UserDAOImpl.class.getDeclaredField("connection");
        connectionField.setAccessible(true);
        connectionField.set(userDAO, connection);

        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    void testFindByLoginNotFound() throws SQLException {
        String login = "unknown";
        when(resultSet.next()).thenReturn(false);

        User user = userDAO.findByLogin(login);

        assertNull(user);
    }

    @Test
    void testFindByIdNotFound() throws SQLException {
        int userId = 999;
        when(resultSet.next()).thenReturn(false);

        User user = userDAO.findById(userId);

        assertNull(user);
    }

    @Test
    void testFindByLoginSQLException() throws Exception {
        String login = "admin";
        when(preparedStatement.executeQuery()).thenThrow(new SQLException("Database error"));

        assertThrows(RuntimeException.class, () -> userDAO.findByLogin(login));
    }
}