package com.conditionalstatements;

import java.util.*;

public class find_largest_value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = sc.nextInt();
        System.out.println("Enter b:");
        int b = sc.nextInt();
        System.out.println("Enter c:");
        int c = sc.nextInt();

        if(a>=b && a>=c){
            System.out.println("largest Number is a:" + a);
        }
        else if(b>=a && b>=c){
            System.out.println("largest Number is b:" + b);
        }
        else{
            System.out.println("largest Number is c:" + c);
        }
        sc.close();
    }
}
