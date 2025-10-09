package com.Array.IntroductionToArray;

import java.util.*;

public class Sum_average {
    public static void main(String[] args) {
        Scanner input  =  new Scanner(System.in);
        double [] num = new double [5];
        System.out.print("Please Enter 5 num:");
        double sum = 0;
        
        for(int i=0; i<num.length; i++){
            num[i] = input.nextDouble();
        }

        for(int i=0; i<num.length; i++){
            sum = sum + num[i];
        }

        System.out.println("Sum is:" + sum);
        System.out.println("The Aveerage is:" + sum/num.length);
    }  
}
