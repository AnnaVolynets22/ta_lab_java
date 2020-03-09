package com.epam.lab.airportdb.model;

public class FlightBooking {
    private Integer bookingId;
    private Flight flight;
    private Passager passager;
    private String seat;

    public FlightBooking(Flight flight, Passager passager, String seat) {
        this.flight = flight;
        this.passager = passager;
        this.seat = seat;
    }

    public FlightBooking(Integer bookingId, Flight flight, Passager passager, String seat) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passager = passager;
        this.seat = seat;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passager getPassager() {
        return passager;
    }

    public void setPassager(Passager passager) {
        this.passager = passager;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "bookingId=" + bookingId +
                ", flight=" + flight.toString() +
                ", passager=" + passager.toString() +
                ", seat='" + seat + '\'' +
                '}';
    }
}
