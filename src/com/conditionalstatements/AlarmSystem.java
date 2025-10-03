package com.conditionalstatements;

import java.util.*;

public class AlarmSystem {
  public static void main(String[] args) {
      try (Scanner sc = new Scanner(System.in)) {
        System.out.println("Enter time(0-23): ");
        System.out.println("Is it raining?(true/false):");

        int time = sc.nextInt();
        boolean isRainy = sc.nextBoolean();

        if(time>=6 && time<=8 &&!isRainy){
            System.out.println("Wake up & Go Jogging");
        }
        else if(isRainy){
            System.out.println("Sleep More");
        }
        else if(time > 22){
            System.out.println("Go to Sleep");
        }
        else{
            System.out.println("Do your regular activities");
      }
    }   
  }
}
