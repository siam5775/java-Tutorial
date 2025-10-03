package com.OOPs.Polymorphism.Code;

class Animal {
    Animal getAnimal() {
       System.out.println("Animal object");
    return new Animal();
    }
}


class Dog extends Animal {
   @Override
    Dog getAnimal() { // covariant return type (Dog is subclass of Animal)
        System.out.println("Dog object");
    return new Dog();
    }
}

public class Covarient_returnTypeInOverridding {
    public static void main(String[] args) {
        Animal a = new Dog();
        Animal result = a.getAnimal(); // calls Dog's method at runtime
    }
}
