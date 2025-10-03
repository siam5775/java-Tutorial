package com.Mid;

public class Increment {
    
    public static void main(String[] args) {
        int i = 0, j = 5;

        for ( ; (i < 3) && (j < 10); j++) {
            System.out.println(" "+ i++ + " " + j);
        }

        System.out.print(" "+ i++ +" "+ j);
    }
}

