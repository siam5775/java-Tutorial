package com.Errortrece;

class Parent {
    int a;

    Parent(int a) {
        this.a = a;
    }

    void show() {
        System.out.println("Parent: " + a);
    }
}

class Child extends Parent {
    

    Child(int a) {
        super(a);
    }

    void show(int a) {
        System.out.println("Child int: " + a);
    }
}

public class Demo {
    public static void main(String[] args) {
        Child c = new Child(50);
        c.show();
        c.show(100);
    }
}
