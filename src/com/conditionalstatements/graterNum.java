package com.conditionalstatements;

import java.util.*;

public class graterNum {
   public static void main(String[] args){
       try (Scanner sc = new Scanner(System.in)) {
        int a = sc.nextInt();
           int b = sc.nextInt();

           if(a>b){
            System.out.println("a is greater then b");
           }
           else if(a<b){
            System.out.println("b is greater than b");
           }
           else{
            System.out.println("Two Num are equal");
           }
       }
   } 
}
  