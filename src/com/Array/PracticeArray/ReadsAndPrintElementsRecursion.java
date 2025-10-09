package com.Array.PracticeArray;

import java.util.Scanner;

public class ReadsAndPrintElementsRecursion {

    public static void readArray(int[] arr, int index, Scanner sc) {
        if (index == arr.length) {
            return;
        }
        System.out.print("Enter element " + (index + 1) + ": ");
        arr[index] = sc.nextInt();
        readArray(arr, index + 1, sc); 
    }

    
    public static void printArray(int[] arr, int index) {
        if (index == arr.length) {
            return;
        }
        System.out.println("Element " + (index + 1) + ": " + arr[index]);
        printArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.println("Reading Array Elements");
        readArray(array, 0, sc); 

        System.out.println("Printing Array Elements");
        printArray(array, 0);

        sc.close();
    }
}
