package com.Array.PracticeArray;

import java.util.*;

public class CopyElementsAnother {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter elements in the array: ");
        int n = sc.nextInt();

        int[] original = new int[n]; 
        int[] copy = new int[n];     

        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            original[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            copy[i] = original[i];
        }

        System.out.println("Elements copied to new array:");
        for (int i = 0; i < n; i++) {
            System.out.print(copy[i] + " ");
        }

        sc.close();
    }

}