package com.Loops;

import java.util.*;

public class TableofNum {
    public static void main(String[] args) {
     
        try (Scanner sc = new Scanner(System.in)) {
        System.out.println("Enter a Numner: ");
        int Num = sc.nextInt();
        int Limit = 10;
        for(int i=1;i<=Limit;i++){
        System.out.println(Num + "x" + i + "=" + (Num*i));
        }
      }
    }
}