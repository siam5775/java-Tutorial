package com.OOPs.Inheritance;

class Shapes{
    public void area(){
        System.out.println("Display area");
    }
}

class Triangle3 extends Shapes{
    public void area(int length,int height){
        System.out.println(1/2*length*height);
    }
}

class EqulateralTriangle extends Triangle3{
     public void area(int length,int height){
        System.out.println(1/2*length*height);
    }
}
public class MultiLevel {
    
}
