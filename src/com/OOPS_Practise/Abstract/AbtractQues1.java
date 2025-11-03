package com.OOPS_Practise.Abstract;

//Question: Write a Java program to create an abstract class Animal with an abstract method called sound(). Create subclasses Lion and Tiger that extend the Animal class and implement the sound() method to make a specific sound for each animal.

abstract class Animal {
    abstract void sound();
}

class Lion extends Animal{
    @Override
    void sound(){
        System.out.println("Lion roars");
    }
}

class Tiger extends Animal {
    @Override
    void sound(){
        System.out.println("Tiger growls");
    }
}

public class AbtractQues1 {
    public static void main(String[] args) {
        Animal obj = new Lion();
        obj.sound();

        Animal obj2 = new Tiger();
        obj2.sound();

    }
}
