package com.conditionalstatements;

import java.util.*;

public class gradeverifier {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Input marks(1 to 100): ");
            int marks = sc.nextInt();

            if(marks>90 && marks%5==0){
                System.out.println("Excellent & Lucky");
            }
            else if(marks>90){
                System.out.println("Excellent");
            }
            else if(marks>=70 && marks<=90){
                System.out.println("Good");
            }
            else if(marks>=50 && marks<70){
                System.out.println("Average");
            }
            else{
                System.out.println("Fail");
            }
        }

    }
}
