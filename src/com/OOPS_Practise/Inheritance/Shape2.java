package com.OOPS_Practise.Inheritance;
//Question: Write a java program to create a class called Shape With methods called getPerimeter() and getArea().Create a subclass called Circle that overrides the getPerimeter() and getArea() methods to calculate the area and perimeter of a circle.
public class Shape2 {
    
    public double getPerimeter(){
        return 0.0;
    }

    public double getArea(){
        return 0.0;
    }
}

class Circle extends Shape2{
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getPerimeter(){
        return 2*Math.PI * radius;
    }

    @Override
    public double getArea(){
        return Math.PI * radius * radius;
    }

}
