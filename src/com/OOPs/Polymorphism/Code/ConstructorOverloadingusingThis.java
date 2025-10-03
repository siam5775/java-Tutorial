package com.OOPs.Polymorphism.Code;

class Box {
    int length, width;

    Box() {
        this(5, 10); 
    }

    Box(int length, int width) {
        this.length = length;
        this.width = width;
    }

    void display() {
        System.out.println("Length: " + length + ", Width: " + width);
    }
}

public class ConstructorOverloadingusingThis {
    public static void main(String[] args) {
        Box b = new Box();
        b.display();

        Box b2 = new Box(20, 30);
        b2.display();
    }
}
