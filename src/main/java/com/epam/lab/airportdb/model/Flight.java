package com.epam.lab.airportdb.model;

import java.sql.Timestamp;

public class Flight {
    private Integer flightNumber;
    private Airline airline;
    private Plane plane;
    private City departureCity;
    private City destinationCity;
    private Timestamp departureTime;
    private Timestamp arrivalTime;

    public Flight(Airline airline, Plane plane, City departureCity, City destinationCity, Timestamp departureTime,
                  Timestamp arrivalTime) {
        this.airline = airline;
        this.plane = plane;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Flight(Integer flightNumber, Airline airline, Plane plane, City departureCity, City destinationCity,
                  Timestamp departureTime, Timestamp arrivalTime) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.plane = plane;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", airline=" + airline.getAirlineName() +
                ", plane=" + plane.getPlaneNumber() +
                ", departureCity=" + departureCity.toString() +
                ", destinationCity=" + destinationCity.toString() +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
