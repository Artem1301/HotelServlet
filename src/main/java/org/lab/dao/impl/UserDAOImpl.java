package org.lab.dao.impl;

import org.lab.dao.UserDAO;
import org.lab.model.User;
import org.lab.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private final Connection connection;

    public UserDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        String query = "SELECT id, login, password, is_admin FROM users WHERE login = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by login and password", e);
        }
        return null;
    }

    @Override
    public User findById(int id) {
        String query = "SELECT id, login, password, is_admin FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by ID", e);
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        String query = "SELECT * FROM users WHERE login = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getBoolean("is_admin")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by login", e);
        }
        return null;
    }
}