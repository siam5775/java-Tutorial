package com.OOPS_Practise.EncapsulationRelated;

class S3{
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}
public class ThirdCode {
    public static void main(String[] args) {
        S3 obj1 = new S3();
        S3 obj2 = new S3();
        S3 obj3 = new S3();

        obj1.setName("Siam");
        obj1.setAge(21);
        obj2.setName("Mou");
        obj2.setAge(21);
        obj3.setName("Maisha");
        obj3.setAge(22);

        System.out.println(obj1.getName());
        System.out.println(obj1.getAge());
        System.out.println(obj2.getName());
        System.out.println(obj2.getAge());
        System.out.println(obj3.getName());
        System.out.println(obj3.getAge());
    }
}

