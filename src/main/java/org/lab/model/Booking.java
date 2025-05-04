package org.lab.model;

public class Booking {
    private int guests;
    private String roomClass;
    private String checkIn;
    private String checkOut;

    public Booking(int guests, String roomClass, String checkIn, String checkOut) {
        this.guests = guests;
        this.roomClass = roomClass;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getGuests() { return guests; }
    public String getRoomClass() { return roomClass; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }

    public void setGuests(int guests) { this.guests = guests; }
    public void setRoomClass(String roomClass) { this.roomClass = roomClass; }
    public void setCheckIn(String checkIn) { this.checkIn = checkIn; }
    public void setCheckOut(String checkOut) { this.checkOut = checkOut; }
}