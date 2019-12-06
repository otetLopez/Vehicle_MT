package com.f19.rosette_768425_mt;

public class Rent {
    private Car car;
    private Integer numdays;
    private Integer addons;
    private double amount;
    private double totalpayment;


    public void setCar(Car car) {
        this.car = car;
    }

    public void removeCar() {
        this.car = null;
    }

    public void setNumdays(Integer numdays) {
        this.numdays = numdays;
    }

    public void setAddons(Integer addons) {
        this.addons = addons;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTotalpayment(double totalpayment) {
        this.totalpayment = totalpayment;
    }

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
