package com.Array;

class Example2{

    void Multidimention(){
        //int[][] arr_1 = new int[5][3];
        int[][] arr = {{56,43,6},{37,7,8},{12,56,8}};

        System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[0][2]);

        System.out.println(arr[1][0]);
        System.out.println(arr[1][1]);
        System.out.println(arr[1][2]);

        System.out.println(arr[2][0]);
        System.out.println(arr[2][1]);
        System.out.println(arr[2][2]);
    }


    void demoArray(){
        int ages[] = new int[3];

        String[] names = {"siam","mou","Tanima"};
        
        ages[0] = 34;
        ages[1] = 12;
        ages[2] = 45;
        
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        
    }
}



public class Exapmle_of_ArrayDimmension {
    public static void main(String[] args) {
        Example2 obj = new Example2();
        // obj.demoArray();
        obj.Multidimention();
    }
}
