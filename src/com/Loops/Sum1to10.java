package com.Loops;

import java.util.*;

public class Sum1to10 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("enput a number");

            int num = sc.nextInt();
            int sum=0,i;
            for ( i = 1; i <= num; i++) {
                sum += i;

                
                if (i != num) {
                    System.out.print(i + " + ");
                } else {
                    System.out.print(i + " = ");
                }
            }

            
            System.out.println(sum);
        }
    }
}
