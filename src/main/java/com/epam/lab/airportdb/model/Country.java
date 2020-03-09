package com.epam.lab.airportdb.model;

public class Country {
    private String countryName;
    private boolean isEu;

    public Country(String countryName, boolean isEu) {
        this.countryName = countryName;
        this.isEu = isEu;
    }

    public String getCountryName() {
        return countryName;
    }

    public boolean isEu() {
        return isEu;
    }

    public void setEu(boolean eu) {
        isEu = eu;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + countryName + '\'' +
                ", isEu=" + isEu +
                '}';
    }
}
