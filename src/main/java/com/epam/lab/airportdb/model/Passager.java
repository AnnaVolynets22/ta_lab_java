package com.epam.lab.airportdb.model;

public class Passager {
    private Integer id;
    private String secondName;
    private String firstName;
    private String nationality;
    private Integer age;
    private ContactDetails contacts;

    public Passager(String secondName, String firstName, String nationality, Integer age, ContactDetails contacts) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.nationality = nationality;
        this.age = age;
        this.contacts = contacts;
    }

    public Passager(Integer id, String secondName, String firstName, String nationality, Integer age,
                    ContactDetails contacts) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.nationality = nationality;
        this.age = age;
        this.contacts = contacts;
    }

    public Integer getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ContactDetails getContacts() {
        return contacts;
    }

    public void setContacts(ContactDetails contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Passager{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                ", contacts=" + contacts.toString() +
                '}';
    }
}
