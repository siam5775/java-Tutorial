package com.Loops;
import java.util.*;
public class Factorial {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a Number:");
       int num = sc.nextInt();
       int fact=1;
       StringBuilder steps = new StringBuilder();

       for(int i=1;i<=num;i++){
        fact = fact*i;
        steps.append(i);

        if(i!=num){
            steps.append("*");
        }
       }
       System.out.println("Factorial value is: "+ steps + " = " + fact);
   
       sc.close();
    }
}
