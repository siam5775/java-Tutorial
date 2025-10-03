package com.Function;

import java.util.*;

public class SumAllOddNum1toN {

    public static void AverageOdd(int num){
        int sum = 0;
        for(int i=1;i<=num;i++){
            if(i%2!=0){
               sum = sum + i;
               System.out.println("Odd Num is: "+i);
            }
        }
        System.out.println("Sum of Odd Num is: "+sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Num:");
        int num = sc.nextInt();
        AverageOdd(num);
        sc.close();
    }
}
