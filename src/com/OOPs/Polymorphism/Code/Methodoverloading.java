package com.OOPs.Polymorphism.Code;

class Calculator{
    public int main(int a,int b){
        return a+b;
    }
    public int main(int a,int b,int c){
        return a+b+c;
    }
    public double main(double a,double b){
        return a+b;
    }
}
public class Methodoverloading {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        System.out.println(obj.main(2,3,4));
        System.out.println(obj.main(2,3));
        System.out.println(obj.main(3.4,3.4));

    }
}
