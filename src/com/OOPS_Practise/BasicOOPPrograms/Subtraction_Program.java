package com.OOPS_Practise.BasicOOPPrograms;

class Subtracting{
    int a = 10;
    int b = 20;

    public void subtract(){
       System.out.println(this.a-this.b); 
    }
}
public class Subtraction_Program {
    public static void main(String[] args) {
        Subtracting obj1 = new Subtracting();
        obj1.subtract();
    }
}
