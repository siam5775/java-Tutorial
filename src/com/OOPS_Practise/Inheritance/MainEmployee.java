package com.OOPS_Practise.Inheritance;

public class MainEmployee {
    public static void main(String[] args) {
        Employee E = new Employee(4000.45);
        HRManager Hr = new HRManager(7000.45);
        
        E.work();
        double salary = E.getSalary();
        System.out.println("Employee Salary:" + salary);

        
        Hr.work();
        System.out.println("Manager Salary:" + Hr.getSalary());
        Hr.addEmployee();
    }
}
