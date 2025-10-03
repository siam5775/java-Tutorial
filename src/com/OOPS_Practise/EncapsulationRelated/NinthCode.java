package com.OOPS_Practise.EncapsulationRelated;

class Siam{
    private int age;

    public Siam(int age){
        this.age = age;
    }

    private int CalculateBirthYear(){
        int Currentyear=2025;

        return Currentyear - age;
        
    }
    
    public int getyearOfBirth(){
        return CalculateBirthYear();
    }
}
public class NinthCode {
    public static void main(String[] args) {
        Siam obj = new Siam(21);

        System.out.println(obj.getyearOfBirth());
    }
}
