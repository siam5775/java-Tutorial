package com.Mid;

public class AddingValueByStaticMethod {
    static int value = 10; // current value

    // static method to add number
    public static void addValue(int n) {
        value = value + n;
    }

    public static void main(String[] args) {
        System.out.println("Before adding: " + value);
        addValue(15); // add 15
        System.out.println("After adding: " + value);
    }
}
