package org.lab.model;

public class Room {
    private int id;
    private String name;
    private int capacity;
    private String roomClass;

    public Room(int id, String name, int capacity, String roomClass) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.roomClass = roomClass;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getRoomClass() { return roomClass; }
}