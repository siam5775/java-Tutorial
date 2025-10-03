package com.Loops;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int x = a;
        int y = b;

        while (y!=0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        System.out.println("GCD of " + a + " and " + b + " is: " + x);
        sc.close();
    }
}
