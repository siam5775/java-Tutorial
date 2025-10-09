package com.Array.PracticeArray;

import java.util.*;
public class SecondLargestElementFind {
    
    public static void findSecondLarge(int [] array,int index,int largest,int secondLargest){
        if(index == array.length){
            System.out.println("largest element:" + largest);
            System.out.println("Second largest element:" + secondLargest);
            return;
        }

        int current = array[index];

        if(current>largest){
            secondLargest = largest;
            largest = current;
        }else if(current>secondLargest && current != largest){
            secondLargest = current;
        }

        findSecondLarge(array, index + 1, largest, secondLargest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        int size = sc.nextInt();

        int [] arr = new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        if(size<2){
            System.out.println("Array must be have at least teo elemnts");
        }

        int largest,secondLargest;

        if(arr[0]>arr[1]){
            largest = arr[0];
            secondLargest = arr[1];
        }else{
            largest = arr[1];
            secondLargest = arr[0];
        }

        findSecondLarge(arr, 2, largest, secondLargest);
        sc.close();
    }
}
