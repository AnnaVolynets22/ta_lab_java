package com.epam.lab.iohw.task1;

public class DroidClass2 extends Droid {
    private transient int power;

    public DroidClass2(String name, int power) {
        super(name);
        this.power =power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "DroidClass2{" +
                "name:" + super.getName() + " power="+  power +
                '}';
    }
}
