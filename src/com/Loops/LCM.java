package com.Loops;
import java.util.Scanner;
public class LCM {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        int x = a;
        int y = b;

        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        int lcm = (a * b) / gcd;
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
        sc.close();
    }
}
