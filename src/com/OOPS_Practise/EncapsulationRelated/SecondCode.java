package com.OOPS_Practise.EncapsulationRelated;

class S2{
    private String name;
    private int age;


    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        if(age>0){
        this.age = age;
        }else{
            System.out.println("Age Not Valid");
        }
    }

    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }

}

public class SecondCode {
    public static void main(String[] args) {
        S2 obj = new S2();

        obj.setName("Siam");
        obj.setAge(21);

        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
