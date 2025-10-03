package com.SwitchCase;
import java.util.*;
public class simplecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter a operator(+,-,*,/):");
            char operator = sc.next().charAt(0);
            System.out.println("Enter two number:");
            double num1 = sc.nextDouble();
            double num2 = sc.nextDouble();
            double result;
            switch(operator){
                case '+': 
                    result = num1+num2;
                    System.out.println(result);
                    break;
                case '-': 
                    result = num1-num2;
                    System.out.println(result);
                    break;
                case '*': 
                    result = num1*num2;
                    System.out.println(result);
                    break;
                case '/': 
                    if(num2!=0){
                    result = num1/num2;
                        System.out.println(result);
                    }else{
                        System.out.println("Error: Cannot divide by zero!");
                    }
                    break;
                default:
                    System.out.println("invalid operator");    
                
            }
        sc.close();
    }
}