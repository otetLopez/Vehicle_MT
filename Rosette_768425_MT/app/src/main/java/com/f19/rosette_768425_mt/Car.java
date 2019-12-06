package com.f19.rosette_768425_mt;

public class Car implements java.io.Serializable{
    private String name;
    private double rent;


    public Car(String name) {
        this.name = name;
        this.rent = 0.0;
    }

    public Car(String name, double rent) {
        this.name = name;
        this.rent = rent;
    }

    public String getName() {
        return name;
    }

    public double getRent() {
        return rent;
    }
}
