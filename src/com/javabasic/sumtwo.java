package com.javabasic;

import java.util.Scanner;

public class sumtwo {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        int sum = num1 + num2;

        System.out.println("Sum = " + sum);

        input.close();
    }
    
}
