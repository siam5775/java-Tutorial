package com.OOPS_Practise.Inheritance;

public class Vehicle {
    public void drive(){
        System.out.println("Vehicle type Name");
    }
}

class Car extends Vehicle{
    public void drive(){
        System.out.println("Repairing a car");
    }
}
