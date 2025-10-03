package com.conditionalstatements;

import java.util.*;

public class Leapyear {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Year: ");
            int year = sc.nextInt();

            if(((year%2==0 && year%100!=0)||(year%400==0)) && year%100==0){
              System.out.println("Leap Century Year");
            }
            else if((year%2==0 && year%100!=0)||(year%400==0)){   
              System.out.println("Leap Year");
            }
            else{
                System.out.println("Not Leap Year");
            }
        }
    }
}
