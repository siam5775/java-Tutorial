package com.OOPs.Polymorphism.Code;
// Interface
interface Shape {
    void draw();
}

// Implementing classes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}
public class PolymorphismWithInterface {
    public static void main(String[] args) {
        // Interface reference variable
        Shape s1 = new Circle();      // Circle object assigned
        Shape s2 = new Rectangle();   // Rectangle object assigned

        // Run-time polymorphism in action
        s1.draw();  // Circle's draw() executed
        s2.draw();  // Rectangle's draw() executed
    }

}
