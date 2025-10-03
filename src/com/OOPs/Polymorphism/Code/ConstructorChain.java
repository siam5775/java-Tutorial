package com.OOPs.Polymorphism.Code;

class Student2 {
    String name;
    int age;

   
    Student2() {
        this("Unknown");  
    }
    
    Student2(String name) {
        this(name, 18);   
    }
    
    Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class ConstructorChain {
    public static void main(String[] args) {
        Student2 s1 = new Student2();
        s1.display();
        Student2 s2 = new Student2("siam");
        s2.display();
        Student2 s3 = new Student2("siam",23);
        s3.display();
    }
}

