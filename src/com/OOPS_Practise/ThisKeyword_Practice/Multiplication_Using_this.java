package com.OOPS_Practise.ThisKeyword_Practice;

class Multiply{
    int a=10,b=15;
    
    public void multiply(int a,int b){
        this.a = a;
        this.b = b;
        System.out.println(this.a*this.b);
    }
}
public class Multiplication_Using_this {
    public static void main(String[] args) {
        Multiply obj = new Multiply();
        obj.multiply(5,2);
    }
}
