package com.OOPs.Basic;

public class Pass_By_Value {

    static void changeValue(int a){
        a = a*100;
        System.out.println("Inside Change Value: "+ a);
    }


    public static void main(String[] args) {
        int a = 10;
        System.out.println("Before Changing Value: "+ a);
        changeValue(a);
        System.out.println("after Changing Value: "+ a);
    }
}
