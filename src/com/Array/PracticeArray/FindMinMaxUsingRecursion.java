package com.Array.PracticeArray;

import java.util.*;

public class FindMinMaxUsingRecursion {
    
    public static int findMax(int [] arr,int index,int max){
        if(index==arr.length){
            return max;
        }

        if(arr[index]>max){
            max = arr[index];
        }

        return findMax(arr,index+1,max);
    }
    public static int findMin(int [] arr,int index,int min){
        if(index==arr.length){
            return min;
        }

        if(arr[index]<min){
            min = arr[index];
        }

        return findMax(arr,index+1,min);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size:");
        int size = sc.nextInt();

        int [] array = new int[size];
        for(int i=0;i<array.length;i++){
            array[i] = sc.nextInt();
        }

        int max = findMax(array,1,array[0]);
        int min = findMin(array,1,array[0]);

        System.out.println("MAx element is:" + max);
        System.out.println("Minimum Element is:" + min);

        sc.close();
    }
}
