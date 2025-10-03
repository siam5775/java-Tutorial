package com.conditionalstatements;

import java.util.*;

public class ATMTrans {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your amount: ");
            double amount = sc.nextDouble();
            System.out.println("Enter your balance: ");
            double balance = sc.nextDouble();

            if(amount>balance){
                System.out.println("Insufficiant balance");
            }
            else if((amount%100==0) && ((balance-amount)>=500)){
                System.out.println("allow transaction");
            }
            else{
                System.out.println("“Minimum balance must be $500”");
            }
        }      
    }
}