package com.OOPS_Practise.Inheritance;

public class MainShape2 {
    public static void main(String[] args) {
        double r = 8.8;
        Circle c1 = new Circle(r);
        System.out.println("Radius of Circle:" + r);
        System.out.println("Perimeter of this Circle:" + c1.getPerimeter());
        System.out.println("Area of this circle:" + c1.getArea());
        
        r  = 4.5;
        Circle c2 = new Circle(r);
        System.out.println("Radius of Circle:" + r);
        System.out.println("Perimeter of this Circle:" + c2.getPerimeter());
        System.out.println("Area of this circle:" + c2.getArea());
    }
}
