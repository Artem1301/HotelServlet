package org.lab.util;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel", "user", "password");
    }
}