package com.OOPs.Basic;
public class MainAlgebra {
    public static void main(String[] args) throws Exception {
        Algebra obj = new Algebra(5,7);
        System.out.println("sum of input number: ");

        System.out.println(obj.add());
        System.out.println(obj.sub());
        System.out.println(obj.mul());

        Algebra obj2 = new Algebra(10,7);
        System.out.println("sum of input number: ");

        System.out.println(obj2.add());
        System.out.println(obj2.sub());
        System.out.println(obj2.mul());
    }
}