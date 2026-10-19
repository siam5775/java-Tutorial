package com.Errortrece;

class A {
    private int x = 5;

    A() {
       x=10;
    }

    public void show() {
        System.out.println("A: " + x);
    }
}

class B extends A {
    int x = 50;

    @Override
    public void show() {
        System.out.println("B: " + x);
    }
}

public class Test {
    public static void main(String[] args) {
        A obj = new B();
         
        obj.show();
    }
}


