package com.OOPS_Practise.ThisKeyword_Practice;

class Updating{
    int num = 50;

    public void updateNum(){
        int a = 20;
        this.num = a;
        System.out.println(a);
        System.out.println(this.num);
    }
}
public class Updating_Class_Variable {
    public static void main(String[] args) {
        Updating obj = new Updating();
        obj.updateNum();
    }
}
