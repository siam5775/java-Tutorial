package com.OOPS_Practise.EncapsulationRelated;

class S{
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

public class FirstCode {
    public static void main(String[] args) {
        S obj = new S();

        obj.setName("Siam");
        obj.setAge(21);

        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
