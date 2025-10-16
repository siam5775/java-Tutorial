package com.String.PracticeExcString;

import java.util.Scanner;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        input = input.toLowerCase();
        int[] freq = new int[256];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch]++;
        }
        
        int maxFreq = 0;
        char maxChar = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = (char) i;
            }
        }
        
        
        sc.close();

        System.out.println("Character with highest frequency: '" + maxChar + "' occurred " + maxFreq + " times.");

        
    }
}
