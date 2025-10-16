package com.OOPs.Inheritance.code;

class Shape2{
    public void area(){
        System.out.println("Display area");
    }
}

class Triangle2 extends Shape2{
    public void area(int length,int height){
        System.out.println(1/2*length*height);
    }
}

public class Single_level_inheritance {
    
}
