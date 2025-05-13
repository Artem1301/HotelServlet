package org.lab.model;

import java.sql.Date;

public class Booking {
    private int id;
    private int userId;
    private String firstName;
    private String middleName;
    private String phone;
    private int capacity;
    private String roomClass;
    private Integer roomId; // Додаємо roomId
    private Date startDate;
    private Date endDate;
    private String status;

    public Booking(int userId, String firstName, String middleName, String phone, int capacity, String roomClass, Date startDate, Date endDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.capacity = capacity;
        this.roomClass = roomClass;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "pending";
    }

    public Booking(int id, int userId, String firstName, String middleName, String phone, int capacity, String roomClass, Integer roomId, Date startDate, Date endDate, String status) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
        this.capacity = capacity;
        this.roomClass = roomClass;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Booking(int i, String john, String doe, String number, int i1, String standard, Object o, Object o1, String pending) {
    }


    // Геттери та сеттери
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getPhone() { return phone; }
    public int getCapacity() { return capacity; }
    public String getRoomClass() { return roomClass; }
    public Integer getRoomId() { return roomId; } // Додаємо геттер для roomId
    public void setRoomId(Integer roomId) { this.roomId = roomId; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}