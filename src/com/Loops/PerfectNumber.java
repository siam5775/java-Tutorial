package com.Loops;

import java.util.Scanner;
    public class PerfectNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a num: ");
        int num = sc.nextInt();
        int sum=0;

        for (int i=1;i<=num/2;i++) {
            if (num%i== 0) {
                sum=sum+i;
            }
        }
        if (sum==num) {
            System.out.println(num + " Perfect Number");
        } else {
            System.out.println(num + "NOT Perfect Number");
        }
        sc.close();
    }   
}
