package com.OOPs.Polymorphism.Code;

class Vehicle{
    void start(){
        System.out.println("Start Vehicle");
    }
}

class Car extends Vehicle{
    void start(){
        System.out.println("Car Run");
    }
}

class Bike extends Vehicle{
    void start(){
        System.out.println("Bike Run");
    }
}
public class MethodOverRiding {
    public static void main(String[] args) {
        Vehicle obj;
        obj = new Car();
        obj.start();
        obj = new Bike();
        obj.start();

        
    }
}
