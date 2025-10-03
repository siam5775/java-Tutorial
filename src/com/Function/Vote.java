package com.Function;

import java.util.Scanner;

public class Vote {
     public static boolean Voter(int age){
       
        if(age>=18){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age:");
        int age=sc.nextInt();

        if(Voter(age)){
            System.out.println("He can give Vote");
        }else{
            System.out.println("He can not give vote");
        }
        sc.close();
    }
}
