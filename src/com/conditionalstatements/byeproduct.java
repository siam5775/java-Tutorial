package com.conditionalstatements;

import java.util.Scanner;

public class byeproduct {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int cash = sc.nextInt();
            if(cash < 10){
                System.out.println("cannot buy a pen");
                System.out.println("get more cash");
            }
            else if(cash>10 && cash <50){
                System.out.println("can get one thing");
            }
            else{
                System.out.println("can get both thing");
            }
        }
    }
}
