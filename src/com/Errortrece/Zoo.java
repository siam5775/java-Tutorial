package com.Errortrece;

interface Flyable {
    void fly();
    void land(); 
}

abstract class Bird implements Flyable {
    abstract void sing();

    public void fly() {
        System.out.println("Bird flying");
    }
}

class Parrot extends Bird {
    void sing() {
        System.out.println("Parrot sings");
    }

    public void land() {
        System.out.println("Parrot land");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Flyable f = new Parrot();
        f.fly();
        f.land();
    }
}

