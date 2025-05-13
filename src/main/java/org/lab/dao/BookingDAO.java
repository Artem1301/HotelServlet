// BookingDAO.java
package org.lab.dao;

import org.lab.model.Booking;

import java.util.List;

public interface BookingDAO {
    void create(Booking booking);
    List<Booking> findByUserId(int userId);
    List<Booking> findAllPending();
    Booking findById(int id); // Додаємо метод
    void update(Booking booking); // Додаємо метод
}