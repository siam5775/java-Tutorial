package com.OOPS_Practise.BasicOOPPrograms;

class Average{
    int a = 10,b=5,c=6;

    public void averageNum(){
        System.out.println((this.a+this.b+this.c)/3);
    }
}
public class Average_of_Three_Number {
    public static void main(String[] args) {
        Average obj = new Average();
        obj.averageNum();
    }
}
