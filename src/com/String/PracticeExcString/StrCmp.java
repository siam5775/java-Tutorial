package com.String.PracticeExcString;

import java.util.*;

public class StrCmp {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Enter First String:");
       String str1 = sc.nextLine();
       System.out.println("Enter Second String:");
       String str2 = sc.nextLine();

       if(str1.compareTo(str2) == 0){
        System.out.println("String are Equal");
       }
       else{
        System.out.println("String are not Equal");
       }
       sc.close();

    }
}
