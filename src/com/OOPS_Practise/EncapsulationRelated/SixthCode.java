package com.OOPS_Practise.EncapsulationRelated;

class BankAc{
    private double balance;

    public BankAc(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
}
public class SixthCode {
    public static void main(String[] args) {
        BankAc obj = new BankAc(2230.00);

        System.out.println(obj.getBalance());
    }
}
