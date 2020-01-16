package com.epam.lab.hypermarketoop;

public class Client {
    private String firstName;
    private String secondName;
    private Address address;
    private String email;

    public Client(String firstName, String secondName, Address address, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
