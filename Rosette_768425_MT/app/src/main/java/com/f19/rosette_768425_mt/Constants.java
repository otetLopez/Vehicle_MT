package com.f19.rosette_768425_mt;

public class Constants {

    public final static Integer AVAILABLE_CARS = 8;
    public final static String[] car = {"Subaru", "Honda", "Mitsubishi", "Nissan", "Dodge", "Acura", "Lexus", "Audi"};
    public final static double[] price = {60, 40, 40, 35, 38, 45, 56, 55, 50};


    public static String[] getCar() {
        return car;
    }

    public static double[] getPrice() {
        return price;
    }
}
