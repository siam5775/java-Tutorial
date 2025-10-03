package com.Loops;

import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            boolean Prime = true;

            if (num < 2) {
                Prime = false;
            } else if (num == 2) {
                Prime = true;
            } else if (num % 2 == 0) {
                Prime = false;
            } else {
                for (int i = 3; i <= Math.sqrt(num); i =i+2) {
                    if (num % i == 0) {
                        Prime = false;
                        break;
                    }
                }
            }

            if (Prime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        }

        
    }
}