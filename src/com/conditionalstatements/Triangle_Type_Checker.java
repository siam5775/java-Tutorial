package com.conditionalstatements;

import java.util.*;

public class Triangle_Type_Checker {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.println("Input 3 sides : ");
           int side1 = sc.nextInt();
           int side2 = sc.nextInt();
           int side3 = sc.nextInt();

           if(side1==side2 && side2==side3){
            System.out.println("Equilateral");
           }
           else if(side1==side2 && side2!=side3){
            System.out.println("Isosceles");
           }
           else{
            System.out.println("Scalene");
           }
           sc.close();
       }
    
}
