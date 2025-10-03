package com.OOPS_Practise.EncapsulationRelated;

class BA{
    private double balance;
    private String pin;

    public BA(double balance,String pin){
        this.balance = balance;
        this.pin = pin;
    }

    public void setPin(String pin){
        this.pin = pin;
    } 
}
public class SeventhCode {
    public static void main(String[] args) {
        BA obj = new BA(222.22,"128531");

        obj.setPin("123456");
    }
}
