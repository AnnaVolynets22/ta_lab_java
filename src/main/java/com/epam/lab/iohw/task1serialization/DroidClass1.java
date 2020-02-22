package com.epam.lab.iohw.task1serialization;

public class DroidClass1 extends Droid {
    private  int power;

    public DroidClass1(String name, int power) {
        super(name);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "DroidClass1{" +
                "name:" + super.getName() + " power="+  power +
                '}';
    }
}
