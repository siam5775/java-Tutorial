package com.OOPs.Inheritance.code;

class Shape{
    public void area(){
        System.out.println("Display area");
    }
}

class Triangle extends Shape{
    public void area(int length,int height){
        System.out.println(1/2*length*height);
    }
}

class Circle extends Shape{
    public void area(int r){
        System.out.println((3.14)*r*r);
    }
}

public class HierarchaiLevel {
    
}
