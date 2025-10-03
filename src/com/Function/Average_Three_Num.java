package com.Function;
import java.util.*;
public class Average_Three_Num {
   public static void AverageNum(double num1,double num2,double num3){
      double Sum = num1 + num2 + num3;
      double Average = Sum/3;
      System.out.println("Sum is: " +Sum);
      System.out.println("Average is: "+Average);
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter Num1:");
         double num1=sc.nextDouble();
         System.out.print("Enter Num2:");
         double num2=sc.nextDouble();
         System.out.print("Enter Num3:");
         double num3=sc.nextDouble();

         AverageNum(num1,num2,num3);
         sc.close();
   } 
}
