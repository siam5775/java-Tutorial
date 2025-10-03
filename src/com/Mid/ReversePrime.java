package com.Mid;
import java.util.Scanner;
public class ReversePrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        int id = sc.nextInt();

        int reversed = 0,remainder;
        while (id > 0) {
            remainder = id % 10;
            reversed = reversed * 10 + remainder;
            id /= 10;
        }

        boolean Primenum = true;
        if (reversed <= 1) {
            Primenum = false;
        } else if (reversed % 2 == 0 && reversed != 2) {
            Primenum = false;
        } else {
            for (int i = 3; i * i <= reversed; i += 2) {
                if (reversed % i == 0) {
                    Primenum = false;
                    break;
                }
            }
        }
        sc.close();

        System.out.println("Reversed Last 4 Digits: " + reversed);

        if (Primenum) {
            System.out.println("Result: " + reversed + " is a Prime Number");
        } else {
            System.out.println("Result: " + reversed + " is NOT a Prime Number");
        }
    }
}


