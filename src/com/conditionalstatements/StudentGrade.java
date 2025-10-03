package com.conditionalstatements;

    import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks for Biology: ");
        int biology = sc.nextInt();
        System.out.print("Enter marks for Mathematics: ");
        int mathematics = sc.nextInt();
        System.out.print("Enter marks for Computer: ");
        int computer = sc.nextInt();

        int total = physics + chemistry + biology + mathematics + computer;
        double percentage = (total / 5.0);  
        String grade;
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else if (percentage >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }
        System.out.println("Total Marks = " + total);
        System.out.println("Percentage = " + percentage + "%");
        System.out.println("Grade = " + grade);

        sc.close();
    }
}

