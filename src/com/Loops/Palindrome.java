package com.Loops;

import java.util.*;

public class Palindrome {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Number:");
    int num = sc.nextInt();
    int remainder,reversed=0,temp;
    temp = num;

    while(num>0){
        remainder = num%10;
        reversed = reversed * 10 + remainder;
        num = num/10;
    }
    if(temp==reversed){
        System.out.println("palindrome");
    }
    else{
        System.out.println("Not Palindrome");
    }
    sc.close();
      
   } 
}
