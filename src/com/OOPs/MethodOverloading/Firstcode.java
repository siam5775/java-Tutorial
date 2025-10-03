package com.OOPs.MethodOverloading;
//function or method overloading
class Students{
    String name;
    int age;

    public void printInfo(String name){
        System.out.println(name);
    }                                 //compile time  polymorphism
    public void printInfo(int age){
        System.out.println(age);
    }
    public void printInfo(String name,int age){
        System.out.println(name + " " + age);
    }
}

public class Firstcode {
    public static void main(String[] args) {
        Students obj1 = new Students();
        obj1.name = "siam";
        obj1.age = 21;

        obj1.printInfo(obj1.name,obj1.age);

    }
}
