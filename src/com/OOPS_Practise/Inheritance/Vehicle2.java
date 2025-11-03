package com.OOPS_Practise.Inheritance;

abstract class Vehicle2 {
    private String make;
    private String model;
    private int year;
    private String fuelType;
    private double fuelEfficiency;

    Vehicle2(String make,String model,int year,String fuelType,double fuelEfficiency){
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.fuelEfficiency = fuelEfficiency;
    }  
}
