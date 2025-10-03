package com.OOPs.Basic;

class Student1{
   String name;
   int age; 

   public void printinfo(){
    System.out.println(this.name);
    System.out.println(this.age);
   }
}


public class secondCode {
    public static void main(String[] args) {
        Student1 s2 = new Student1();
        s2.name = "siam";
        s2.age = 22;

        s2.printinfo();
    }
}
