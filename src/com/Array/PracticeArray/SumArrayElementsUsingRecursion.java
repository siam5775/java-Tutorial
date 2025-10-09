package com.Array.PracticeArray;

import java.util.*;

public class SumArrayElementsUsingRecursion {
    
    public static int findSum(int [] arr,int index){
        if(index==arr.length){
            return 0;
        }

        return arr[index] + findSum(arr, index+1);
    }
    
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter Array Size:");
        int  size = sc.nextInt();
        int [] arr = new int[size];

        for(int i=0;i<arr.length;i++){
            System.out.println("Element " + (i+1) + ":");
            arr[i]=sc.nextInt();
        }

        int sum = findSum(arr,0);

        System.out.println("Sum all array elements:" + sum);
        sc.close();
    }
}
