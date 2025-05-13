package org.lab.dao;

import org.lab.model.User;

public interface UserDAO {
    User findByLoginAndPassword(String login, String password);
    User findById(int id);
    User findByLogin(String login);
}