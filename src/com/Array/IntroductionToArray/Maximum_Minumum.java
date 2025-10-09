package com.Array.IntroductionToArray;

import java.util.Scanner;

public class Maximum_Minumum {
    public static void main(String[] args) {
        Scanner input  =  new Scanner(System.in);
        double [] num = new double [5];
        System.out.print("Please Enter 5 num:");

        for(int i=0; i<num.length; i++){
            num[i] = input.nextDouble();
        }

        double max = num[0];
        for(int i=1;i<5;i++){
            if(max<num[i]){
                max = num[i];
            }
        }
        System.out.println("maximum =" + max);
        
        double min = num[0];
        for(int i =1;i<num.length;i++){
            if(min>num[i]){
                min = num[i];
            }
        }
        System.out.println("minimum number is:" + min);
    }  
}
