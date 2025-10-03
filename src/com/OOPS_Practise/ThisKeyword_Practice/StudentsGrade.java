package com.OOPS_Practise.ThisKeyword_Practice;
class Student {
    String name;
    int marks1, marks2, marks3;

    Student(String name) {
        this.name = name;
    }

    public void setMarks(int marks1, int marks2, int marks3) {
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public void calculateGrade() {
        double average = (this.marks1 + this.marks2 + this.marks3) / 3.0;

        System.out.println("Name: " + this.name);
        System.out.println("Average: " + average);

        if (average >= 80) {
            System.out.println("Grade: A");
        } else if (average >= 60) {
            System.out.println("Grade: B");
        } else if (average >= 40) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
    }
}

public class StudentsGrade {
    public static void main(String[] args) {
      
        Student obj = new Student("Siam");
        obj.setMarks(90, 40, 80);
        obj.calculateGrade();
    }
}
