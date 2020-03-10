package com.epam.lab.airportdb.model;

public class Airline {
    private Integer id;
    private String airlineName;
    private Address address;

    public Airline(String airlineName, Address address) {
        this.airlineName = airlineName;
        this.address = address;
    }

    public Airline(Integer id, String airlineName, Address address) {
        this.id = id;
        this.airlineName = airlineName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", airlineName='" + airlineName + '\'' +
                ", address=" + address +
                '}';
    }
}
