package com.OOPs.Basic;

class Student{
   String name;
   int age; 

   public void printinfo(){
    System.out.println(this.name);
    System.out.println(this.age);
   }

   Student(){
    System.out.println("constructor called");
   }
}

public class Non_prametarized {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "siam";
        s1.age = 22;

        s1.printinfo();
    }
}
