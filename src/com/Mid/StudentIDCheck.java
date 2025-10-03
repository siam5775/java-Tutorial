package com.Mid;
import java.util.Scanner;

public class StudentIDCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter last four digits of your student ID: ");
        int id = sc.nextInt();

        int temp = id, rev = 0;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        if (id == rev) {
            System.out.println(id + " is a Palindrome.");
        } else {
            System.out.println(id + " is NOT a Palindrome.");
        }

        System.out.println("Reversed ID: " + rev);

        boolean isPrime = true;
        if (rev < 2) {
            isPrime = false;
        } else {
            for (int i = 2; i * i <= rev; i++) {
                if (rev % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(rev + " is a Prime Number.");
        } else {
            System.out.println(rev + " is NOT a Prime Number.");
        }

        sc.close();
    }
}
