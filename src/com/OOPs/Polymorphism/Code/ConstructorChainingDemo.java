package com.OOPs.Polymorphism.Code;

class Parent {
    int x;

    Parent() {  
        System.out.println("Parent No-arg constructor");
    }
    Parent(int x) {  
        this.x = x;
        System.out.println("Parent Parameterized constructor: x = " + x);
    }
}

class Child extends Parent {
    int y;

    Child() {  
        super(100);  
        System.out.println("Child No-arg constructor");
    }
    Child(int y) {  
        super();      
        this.y = y;
        System.out.println("Child Parameterized constructor: y = " + y);
    }
}

public class ConstructorChainingDemo {
    public static void main(String[] args) {
        Child child1 = new Child();  

        Child child2 = new Child(50); 
    }
}

