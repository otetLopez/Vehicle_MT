package com.f19.rosette_768425_mt;

import android.util.Log;

import static com.f19.rosette_768425_mt.Constants.*;

public class Rent implements java.io.Serializable {
    private Car car;
    private Integer numdays;
    private Integer addons;
    private double amount;
    private double totalpayment;
    private int user;

    public void setUser(int user) {
        this.user = user;
    }

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
        Log.i("Otet" , "Addon set to " + addons);
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

    public Integer getAddons() {
        return addons;
    }

    public String toString() {
        String userDetails = "";
        switch (user) {
            case 1: {
                userDetails = "Customer below 20";
            }
                break;
            case 2: {
                userDetails = "Customer of safe age between 20 and 60";
            }
                break;
            case 3: {
                userDetails = "Customer is above 60";
            }
            break;
            default:
                break;
        }

        String addonsStr = "Driver has added the following items:\n";
        boolean flag = false;
        int added = this.addons & 1;
        Log.i("Otet", this.addons + " num");
        if(added == 1) {
            addonsStr += "\t- GPS added\n";
            flag = true;
        }
        added = this.addons & 2;
        if(added == 2) {
            addonsStr += "\t- Child seat added\n";
            flag = true;
        }
        added = this.addons & 4;
        if(added == 4) {
            addonsStr += "\t- Unlimited mileage added\n";
            flag = true;
        }

        if(!flag)
            addonsStr = "";

        return String.format( "Rent Details:\n\n" + "Car Type\t\t\t: " + this.car.getName() + "\n" +
                "Car Daily Rent Price\t\t\t: " + this.car.getRent() + "\n" +
                "Total number of rent days\t\t\t: " + this.numdays + "\n" +
                "Driver's Age\t\t\t: " + userDetails + "\n" +
                addonsStr +
                "Total amount tax exclusive\t\t\t: " + String.format("%.2f", this.amount) + "\n" +
                "Total payment to be made\t\t\t: " + String.format("%.2f",this.totalpayment));

    }
}
