package com.OOPs.Basic;

class pen{
    String color;
    String type; //bollpoint,jell

    public void write(){
        System.out.println("Writing Something");
    }

    public void printcolor(){
        System.out.println(this.color);
    }
}


public class OOPS {
    public static void main(String[] args) {
        pen pen1  = new pen();
        pen1.color = "blue";
        pen1.type = "gel";

        pen pen2 = new pen();
        pen2.color = "black";
        pen2.type = "ballpoint";

        pen1.printcolor();
        pen2.printcolor();
    }
}
