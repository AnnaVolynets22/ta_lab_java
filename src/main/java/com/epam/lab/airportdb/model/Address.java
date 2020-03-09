package com.epam.lab.airportdb.model;

public class Address {
    private Integer Id;
    private City city;
    private String street;
    private Integer buildNumber;
    private Integer flatNumber;

    public Address( City city, String street, Integer buildNumber, Integer flatNumber) {
        this.city = city;
        this.street = street;
        this.buildNumber = buildNumber;
        this.flatNumber = flatNumber;
    }

    public Address(Integer id, City city, String street, Integer buildNumber, Integer flatNumber) {
        Id = id;
        this.city = city;
        this.street = street;
        this.buildNumber = buildNumber;
        this.flatNumber = flatNumber;
    }

    public Integer getId() {
        return Id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id=" + Id +
                ", city=" + city.toString() +
                ", street='" + street + '\'' +
                ", buildNumber=" + buildNumber +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
