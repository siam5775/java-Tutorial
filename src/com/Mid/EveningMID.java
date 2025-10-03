package com.Mid;

public class EveningMID {
    public static void main(String[] args) {
        int a = 5; int b = 7;
        int c = a++ + b + ++a;
        System.out.println("First Change\n c ="+c);
        int A = 5; int B = 7;
        int C = ++A + --B + --c;
        System.out.println("First Change\n c ="+C);
    }
}
