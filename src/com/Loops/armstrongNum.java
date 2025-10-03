package com.Loops;

import java.util.*;

public class armstrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number:");
        int Num = sc.nextInt();

        int temp = Num,r,sum=0;

        while(temp!=0){
            r = temp%10;
            sum = sum+(r*r*r);
            temp = temp/10;
        }

        if(sum==Num){
            System.out.println("Armstrong Number");
        }
        else{
            System.out.println("Not Armstrong Number");
        }

        sc.close();
    }
}
