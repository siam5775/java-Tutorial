package com.String.PracticeExcString;

import java.util.Scanner;

public class FindStringLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int length = str.length();
        System.out.println("The length of the string is: " + length);

        sc.close();
    }
}
