package com.casting;

public class price {
    public static void main(String[] args) {
        double price = 100.00;
        double finalprice = price + 18;

        System.out.println(finalprice);
        
//Explicit Casting:
        int p = 100;
        int fp = p + (int)18.0;
        System.out.println(fp);
 
    }
}
