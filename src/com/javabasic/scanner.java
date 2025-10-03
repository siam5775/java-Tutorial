package com.javabasic;

import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        //How To Take Input?
        try (Scanner sc = new Scanner(System.in)){
        System.out.println("Input your age: ");
        System.out.println("Input your name: ");
       
        int age = sc.nextInt();
        System.out.println(age);
        String name = sc.nextLine();
        System.out.println(name);
       
    }
}

}
