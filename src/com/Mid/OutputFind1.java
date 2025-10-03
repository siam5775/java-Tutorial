package com.Mid;

public class OutputFind1 {

    public static void main(String[] args) {
        int a = 5, b = 7;
        int c = (a++ > 3) ? a + b++ : ++a + --b;
        System.out.println("Answer \n c =" + c);
    }
}

