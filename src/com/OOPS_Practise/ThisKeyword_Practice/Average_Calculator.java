package com.OOPS_Practise.ThisKeyword_Practice;

class Average{
    int a=10,b=5,c=8;

    public void calculateAverage(int a,int b,int c){
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println(this.a);
        System.out.println(this.b);
        System.out.println(this.c);
        System.out.println((this.a+this.b+this.c)/3);
    }
}
public class Average_Calculator {
    public static void main(String[] args) {
        Average obj = new Average();
        obj.calculateAverage(4,6,8);
    }
}
