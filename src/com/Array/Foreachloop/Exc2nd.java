package com.Array.Foreachloop;

public class Exc2nd {
     public static void main(String[] args) {
        //enhanced for lopp
       int [] num = {10,20,5,7,8,56,33,100,4,55};
        
       int sum = 0;
        for(int x : num){
            sum = sum+x;
        }
        System.out.println(sum);
    }
}
