package com.String.PracticeExcString;

import java.util.Scanner;

public class StringvowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        str = str.toLowerCase();

        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++; 
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Total vowels: " + vowels);
        System.out.println("Total consonants: " + consonants);

        sc.close();
    }
}
