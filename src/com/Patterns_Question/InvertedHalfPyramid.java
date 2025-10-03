package com.Patterns_Question;

import java.util.Scanner;

public class InvertedHalfPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n:");
        int n = sc.nextInt();
        
        for(int i=1;i<=n;i++){
            for(int j=4;j>=i;j--){
               System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }    
}

