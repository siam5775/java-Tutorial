package com.OOPs.Basic;

class Student2{
    String name;
    int id;

    public void printinfo(){
        System.out.println(this.name);
        System.out.println(this.id);
    }

    Student2(String name,int id){
        this.name = name;
        this.id = id;
    }
}



public class peramitarized_constructor {
    public static void main(String[] args) {
        Student2 s2 = new Student2("siam",1172);
        s2.printinfo();
    }
}
