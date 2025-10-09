package com.Array.IntroductionToArray;

public class FirststArray {
    public static void main(String[] args) {
        int [] number = new int[5];  //declare and create //size 5 //index start 0  all time (+ve)

        number [0] = 10;
        number [1] = 10;
        number [2] = 10;
        number [3] = 10;
        number [4] = 10;
        int sum =  number [0] + number [1] + number [2] + number [3] + number [4];
        int len = number.length; // array size find 
        System.out.println("Array size:" + len);
        System.out.println(number [0]); 
        System.out.println("Sum is:" + sum);
    }
}
