package com.OOPS_Practise.Inheritance;

public class Shape {
    double getArea(){
        System.out.println("Shape no specified");
        return 0;
    }
}

class Rectangle extends Shape{
    double length;
    double width;

    Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    
    @Override
    double getArea(){
        return length*width;
    }
}