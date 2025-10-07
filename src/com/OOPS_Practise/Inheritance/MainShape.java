package com.OOPS_Practise.Inheritance;

public class MainShape {
    public static void main(String [] args){
       Shape S = new Shape();
       S.getArea();
       
       Rectangle R = new Rectangle(5,6);
       double result = R.getArea();
       System.out.println(result);
    }
     
}
