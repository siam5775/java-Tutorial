package com.Errortrece;

interface Drive {
    public void start();
    public void stop();
}

abstract class Vehicle implements Drive {
    public abstract void speed();
    public void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car extends Vehicle {
    @Override
    public void speed() {
        System.out.println("Fast");
    }

    public void stop() {
        System.out.println("Car stopping...");
    }
}

public class Main {
    public static void main(String[] args) {
        Drive d = new Car();
        Vehicle v = (Vehicle) d;
        v.start();
        v.speed();
        v.stop();
    }
}

