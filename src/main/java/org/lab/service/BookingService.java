package org.lab.service;

import org.lab.dao.BookingDAO;
import org.lab.model.Booking;

import java.util.List;

public class BookingService {
    private final BookingDAO dao = new BookingDAO();

    public void save(Booking booking) {
        dao.save(booking);
    }

    public List<Booking> findAll() {
        return dao.findAll();
    }
}
