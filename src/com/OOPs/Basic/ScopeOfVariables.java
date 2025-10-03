package com.OOPs.Basic;
class Scope{
    // int a =10;  //member variable
    // int b = 5;

    // int add(){                         //class level scope
    //   int p = 10;
    //   int q = 20;
    //   return p+q;
    // }

    // int sub(){
    //     int p=0,q=2;
    //     return p-q;
    // }

    void demo(){
        int a  = 39;
        System.out.println(a);
        for(int i = 1;i<=5;i++)
        {
            int b =10;
            System.out.println(b);
        }
        
        if(true)
        {
            int b = 100;
            System.out.println(b);
        }
    }
}

public class ScopeOfVariables {
    public static void main(String[] args) {
        Scope obj = new Scope();
        obj.demo();
    }
}
