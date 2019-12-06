package com.f19.rosette_768425_mt;

public class Constants {

    public final static Integer AVAILABLE_CARS = 8;
    public final static String[] car = {"Subaru", "Honda", "Mitsubishi", "Nissan", "Dodge", "Acura", "Lexus", "Audi"};
    public final static double[] price = {60, 40, 40, 35, 38, 45, 56, 55};

    public final static Integer CUSTOMER_BELOW_20 = 1;
    public final static Integer CUSTOMER_BETWEEN_20_60 = 2;
    public final static Integer CUSTOMER_ABOVE_60 = 3;

    public final static Integer ADD_ONS_GPS = 1; // 001
    public final static Integer ADD_ONS_CHILD_SEAT = 2; // 010
    public final static Integer ADD_ONS_UNLI_MILE = 6; // 100


    public static String[] getCar() {
        return car;
    }

    public static double[] getPrice() {
        return price;
    }
}
