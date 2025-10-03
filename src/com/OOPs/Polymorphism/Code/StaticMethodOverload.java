package com.OOPs.Polymorphism.Code;

class Example {
    
    static void greet() {
        System.out.println("Hello! Welcome to Static Method example.");
    }

    static void greet(String name) {
        System.out.println("Hello " + name + "! Welcome to Static Method example.");
    }
}

public class StaticMethodOverload {
    public static void main(String[] args) {
        Example.greet();
        Example.greet("Siyam");
    }
}

