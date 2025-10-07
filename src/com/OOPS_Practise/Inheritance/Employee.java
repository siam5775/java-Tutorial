package com.OOPS_Practise.Inheritance;

public class Employee {
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    void work() {
        System.out.println("Employee done work");
    }

    double getSalary() {
        return salary;
    }
}

class HRManager extends Employee {

    public HRManager(double salary) {
        super(salary);
    }

    void work() {
        System.out.println("HRManager manage Employee");
    }

    void addEmployee() {
        System.out.println("Company add new Employee");
    }
}