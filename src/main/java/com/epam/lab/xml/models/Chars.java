package com.epam.lab.xml.models;

public class Chars {
    private double alcoholVolume;
    private double transparency;
    private boolean filter;
    private double foodValue;
    private PouringMethod pouringMethod;

    public Chars() {
    }

    public double getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(double alcoholVolume) {
        this.alcoholVolume = alcoholVolume;
    }

    public double getTransparency() {
        return transparency;
    }

    public void setTransparency(double transparency) {
        this.transparency = transparency;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public double getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(double foodValue) {
        this.foodValue = foodValue;
    }

    public PouringMethod getPouringMethod() {
        return pouringMethod;
    }

    public void setPouringMethod(PouringMethod pouringMethod) {
        this.pouringMethod = pouringMethod;
    }

    @Override
    public String toString() {
        return "Char{" +
                "alcoholVolume=" + alcoholVolume +
                ", transparency=" + transparency +
                ", filter=" + filter +
                ", foodValue=" + foodValue +
                ", pouringMethod=" + pouringMethod.toString() +
                '}';
    }
}
