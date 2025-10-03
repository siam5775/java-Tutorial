package com.Loops;

public class print1to10 {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            System.out.println(i);
        }

        int j = 10;
        while(j >= 1){
            System.out.println(j);
            j = j -1;
        }
        
        int k = 10;
        do{
            System.out.println(k);
            k = k - 1;
        }while(k>=1);

    }
}
