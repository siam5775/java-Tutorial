package com.OOPS_Practise.EncapsulationRelated;

class S4{
    private String name;
    private int age;

    public S4(String name, int age){
        this.name = name;
        this.age = age;
    }
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
public class FourthCode {
    public static void main(String[] args) {
        S4 obj = new S4("siam",22);
        
        System.out.println(obj.getName());
        System.out.println(obj.getAge());

        obj.setAge(21);
        obj.setName("Mou");

        System.out.println("After update:");
        System.out.println(obj.getName());
        System.out.println(obj.getAge());

    }
}
