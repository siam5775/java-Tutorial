package com.Function;
import java.util.*;
public class ReturnGreaterNum {
    public static int GreaterNum(int num1,int num2){
        if(num2>num1){
            return num2;
        }else{
            return num1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num1:");
        int num1=sc.nextInt();
        System.out.print("Enter num2:");
        int num2=sc.nextInt();

        int result = GreaterNum(num1,num2);
        System.out.println("Greater Num is: "+result);
        
        sc.close();
    }
}
