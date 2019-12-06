package com.f19.rosette_768425_mt;

public class Rent {
    private Car car;
    private Integer numdays;
    private Integer addons;
    private double amount;
    private double totalpayment;

    public Rent() {
        car = null;
        numdays = 0;
        addons = 0;
        amount = 0.0;
        totalpayment = 0.0;
    }

    public Rent(Car car) {
        this.car = car;
        numdays = 0;
        addons = 0;
        amount = 0.0;
        totalpayment = 0.0;
    }
}
