package com.OOPs.Polymorphism.Code;

class Student{
    String name;
    int Roll;

Student(){
    name = "Siam";
    Roll = 20;
}

Student(String N){
    name = N;
    Roll = 0;
}

Student(String N,int A){
    name = N;
    Roll = A;
}

void Display(){
    System.out.println("Name:" + name + ", Age:" + Roll);
}
}
public class ConstructorOverloading {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Siam");
        Student s3 = new Student("siam",20);

        s1.Display();
        s2.Display();
        s3.Display();
    }
}
