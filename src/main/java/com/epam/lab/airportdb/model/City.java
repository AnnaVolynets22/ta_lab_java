package com.epam.lab.airportdb.model;

public class City {
    private Integer id;
    private String cityName;
    private Country cityCountry;

    public City(String cityName, Country cityCountry) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    public City(Integer id, String cityName, Country cityCountry) {
        this.id = id;
        this.cityName = cityName;
        this.cityCountry = cityCountry;
    }

    public Integer getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCityCountry() {
        return cityCountry;
    }

    public void setCityCountry(Country cityCountry) {
        this.cityCountry = cityCountry;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cityCountry=" + cityCountry.getCountryName() +
                '}';
    }
}
