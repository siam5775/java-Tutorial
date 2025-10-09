package com.Array.Assignment;
import java.util.Scanner;
public class ArrayDay {
    public static void main(String[] args) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.print("Enter a number (1-7) or 0 to exit: ");
            choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            }

            if (choice >= 1 && choice <= 7) {
                System.out.println("Day is: " + days[choice - 1]);
            } else {
                System.out.println("Invalid input! Please enter number between 1 to 7.");
            }
        }
        sc.close();
    }
}