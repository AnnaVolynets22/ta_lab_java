package com.epam.lab.xml.models;

public class PouringMethod {
    private double volume;
    private String material;

    public PouringMethod() {
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "PouringMethod{" +
                "volume=" + volume +
                ", material='" + material + '\'' +
                '}';
    }
}
