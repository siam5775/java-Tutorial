package com.conditionalstatements;

import java.util.*;

public class colorgame {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter First Color:");
            String color1 = sc.next();
            System.out.println("Enter First Color:");
            String color2 = sc.next();
            
            if(color1.equals(color2)){
                System.out.println("Same color - no change");
            }else{
                
                String result="";
            
            switch(color1){
                case "Red":
                if(color2.equals("Blue")){
                    result = "Purple";
                }else if(color2.equals("Yellow")){
                    result = "Orange";
                }break; 

                case "Blue":
                if(color2.equals("Red")){
                    result = "Purple";
                }else if(color2.equals("Yellow")){
                    result = "Green";
                }break; 

                case "YEllow":
                if(color2.equals("Red")){
                    result = "Purple";
                }else if(color2.equals("Blue")){
                    result = "Orange";
                }break; 
                
                default:
                    result = "Invalid color output";
            }   
                
            System.out.println(result);

          }
        }  
    }
}
