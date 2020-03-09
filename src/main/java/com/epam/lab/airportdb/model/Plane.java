package com.epam.lab.airportdb.model;

public class Plane {
    private Integer id;
    private String planeNumber;
    private Integer capacity;

    public Plane(String planeNumber, Integer capacity) {
        this.planeNumber = planeNumber;
        this.capacity = capacity;
    }

    public Plane(Integer id, String planeNumber, Integer capacity) {
        this.id = id;
        this.planeNumber = planeNumber;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", planeNumber='" + planeNumber + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
