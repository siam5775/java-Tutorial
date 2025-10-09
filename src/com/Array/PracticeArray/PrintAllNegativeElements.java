package com.Array.PracticeArray;

import java.util.*;
public class PrintAllNegativeElements{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array:");
        int size = sc.nextInt();

        int [] arr = new int[size];
        System.out.println("Enter the elements of array:");
       
        // main kotha hoilo ami first a size nilam oitare arr variable a store korlam tarpor hoilo for loop calaiam then 0 theke o hoilo arr size er sate check korlo then deklo true 0+1 =1 print korlo tarpor index 0 te akta value scan koira input dilam loop tarvhitore store korlo abr loop cholbo evabe jokn false hbe shob element print hbe...

        for(int i=0;i<arr.length;i++){
           System.out.print("Element" + (i+1) + ":");
           arr[i] = sc.nextInt();         
        }
        
        //ekhne count use mulotw jodi kunota na mile sei jonno ar hoscce koyta millo seita dekhar jonno....loop ager motoi if condition checck korbe ar dekhbe index alue 0 er kom kina kom holei true ar print korbe ar count er man baray dibe...evabe loop er condition false na hou aporjontw cholbe ...

        int count = 0;
        for(int i=0;i<size;i++){
            if(arr[i]<0){
                System.out.println(arr[i]);
                count++;
            }
        }

        if(count==0){
            System.out.println("No negative element");
        }else{
            System.out.println("Total negative element:" + count);
        }
        sc.close();
    }
}