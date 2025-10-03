package com.OOPs.Basic;

class Student3{
    String name;
    int age;

    
    Student3() {
    }

    public void printinfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }

    Student3(Student3 s4){
        this.name = s4.name;
        this.age = s4.age;
    }
}

public class Copy_constructor {
    public static void main(String[] args) {
        Student3 s1 = new Student3();
        s1.name = "siam";
        s1.age = 24;

        Student3 s4 = new Student3(s1);
        s4.printinfo();
    }
}