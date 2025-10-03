package com.OOPS_Practise.EncapsulationRelated;

class S5{
    private String name;
    private int age;
    private String grade;
    
    public S5(String name, int age, String grade){
        this.name = name;
        this.age  = age;
        this.grade = grade;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGrade(int marks){
        
        if(marks>=80){
           this.grade = "A+";
        }
        else if(marks<80 && marks>=70){
            this.grade = "B+";
        }
        else{
            this.grade = "Fail";
        }
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGrade(){
        return grade;
    }
}
public class FifthCode {
    public static void main(String[] args) {
        S5 obj = new S5("siam",23,"A+");
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
        System.out.println(obj.getGrade());
       
        obj.setName("siam");
        obj.setAge(23);
        obj.setGrade(78);
        System.out.println("After Update");
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
        System.out.println(obj.getGrade());
    }
}
