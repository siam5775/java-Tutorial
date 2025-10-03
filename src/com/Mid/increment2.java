package com.Mid;

public class increment2 {
   public static void main(String[] args) {
    int x=0;
    int y=1;

    if(x++>0 || ++y>1){
        System.out.println("true");
    }else{
        System.out.println("x= "+x+"y= "+y);
    }

    int a =5;
    if(++a>5 && a++<10){
        a=a+2;
    }
    System.out.println("a = "+a);
   }
}
