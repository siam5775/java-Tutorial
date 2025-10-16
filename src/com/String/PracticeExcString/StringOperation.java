package com.String.PracticeExcString;

import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine();

        String copy = str1;
        System.out.println("\nCopied string: " + copy);

        String concat = str1 + str2;
        System.out.println("Concatenated string: " + concat);

        if (str1.equals(str2)) {
            System.out.println("Both strings are EQUAL.");
        } else {
            System.out.println("Strings are NOT equal.");
        }

        if (str1.equalsIgnoreCase(str2)) {
            System.out.println("Both strings are equal (case ignored).");
        } else {
            System.out.println("Strings are not equal even if case ignored.");
        }
        sc.close();
    }
}
