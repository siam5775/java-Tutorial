package com.Array;

class Example{
    void demoArray(){
        int ages[] = new int[3];
        
        ages[0] = 34;
        ages[1] = 12;
        ages[2] = 45;
        
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);
        
    }
}


public class Array_Example {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.demoArray();
    }
}
