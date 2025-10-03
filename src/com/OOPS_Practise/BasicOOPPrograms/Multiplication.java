package com.OOPS_Practise.BasicOOPPrograms;

class Multiple{
    int a = 5;
    int b = 5;

    public void multiplication(){
        System.out.println(this.a*this.b);
    }

}
public class Multiplication {
   public static void main(String[] args) {
       Multiple obj1 = new Multiple();
       obj1.multiplication();
   }
}
