package com.Function;

import java.util.*;

public class CircleCircumference {
    public static double Circumference(double r){ 
        return 2*Math.PI*r;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Radius r:");
        double r = sc.nextDouble();

        double result = Circumference(r);
        System.out.println("Circumference is: "+result);

        sc.close();
    }
}
