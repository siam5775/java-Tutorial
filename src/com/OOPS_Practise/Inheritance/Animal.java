package com.OOPS_Practise.Inheritance;

public class Animal {
    void makeSound(){
        System.out.println("Animal makes Sound");
    }
}

class Cat extends Animal {
    @Override
    void makeSound(){
        System.out.println("bark");
    }
}
