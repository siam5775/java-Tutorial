package com.String.PracticeExcString;

import java.util.Scanner;

public class CharacterTypeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        int alphabets = 0;
        int digits = 0;
        int specialChars = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                alphabets++;
            } else if (ch >= '0' && ch <= '9') {
                digits++;
            } else {
                specialChars++;
            }
        }
        System.out.println("Total Alphabets: " + alphabets);
        System.out.println("Total Digits: " + digits);
        System.out.println("Total Special Characters: " + specialChars);

        sc.close();
    }
}
