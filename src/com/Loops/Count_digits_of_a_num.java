package com.Loops;

import java.util.Scanner;

public class Count_digits_of_a_num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int count = 0;
        int temp = n;
    while(temp != 0) {
            temp = temp / 10;
            count++;
        }
        System.out.println("The number of digits is: " + count);
        sc.close();
    }
}
