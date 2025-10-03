package com.OOPS_Practise.BasicOOPPrograms;

class Swap{
    int a = 12;
    int b = 10;
    int temp;

    public void swapNum(){
        this.temp = a;
        this.a = b;
        this.b = temp;
        System.out.println(this.a);
        System.out.println(this.b);
    }
}

public class Swap_Two_Numbers {
    public static void main(String[] args) {
        Swap obj = new Swap();
        obj.swapNum();
    }
}
