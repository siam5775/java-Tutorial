package com.OOPS_Practise.BasicOOPPrograms;

class counter{
    static int count=2;

    public void increment(){
        System.out.println(++count);
    }

}
public class Static_Variable_Counter {
    public static void main(String[] args) {
        counter obj1 = new counter();
        counter obj2 = new counter();
        obj1.increment();
        obj2.increment();
        obj1.increment();
    }
}
