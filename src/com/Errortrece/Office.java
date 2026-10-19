package com.Errortrece;

interface Worker {
    void work();
}

abstract class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }

    abstract void task();

    public void work() {
        System.out.println(name + " is working");
    }
}

class Manager extends Employee implements Worker {
    Manager(String n) {
        super(n);
    }

    void task() {
        System.out.println(name + " manages");
    }

    @Override
    public void work() {
        System.out.println(name + "working");
    }
}

public class Office {
    public static void main(String[] args) {
        Worker w = new Manager("Alice");
        w.work();
        ((Manager)w).task();
        
    }
}

