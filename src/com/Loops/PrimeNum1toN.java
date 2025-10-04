package com.Loops;

import java.util.*;

public class PrimeNum1toN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number: ");
            int Num = sc.nextInt();

            for (int i = 1; i <= Num; i++) {
                if (i < 2) {
                    continue; 
                }

                if (i != 2 && i % 2 == 0) {
                    continue;  
                }

                boolean prime = true;

                
                for (int j = 3; j * j <= i; j = j + 2) {
                    if (i % j == 0) {
                        prime = false;
                        break;
                    }
                }

                if (prime) {
                    System.out.println(i);
                }
            }
            sc.close();
        }
    }

