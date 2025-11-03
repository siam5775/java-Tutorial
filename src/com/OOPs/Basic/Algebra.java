package com.OOPs.Basic;
public class Algebra{
    int a;
    int b;

    Algebra(int x,int y){    //peramitarized Constractor
        System.out.println("Constractor of Algebra Class called");
        this.a = x;
        this.b = y;
    }
    int add(){
        return a+b;
    }

    int sub(){
        return a-b;
    }

    int mul(){
        return a*b; 
    }
}
