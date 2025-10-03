package com.OOPS_Practise.EncapsulationRelated;

class BanAcc{
    private double balance;

    public BanAcc(double balance){
        this.balance = balance;
    }

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Deposiit:" + amount);
    }

    public void withdraw(double amount){
        if(balance >= amount){
            balance  = balance - amount;
            System.out.println("Withdraw:" + amount);
        }else{
            System.out.println("Insuficient Balance");
        }
    }
    
    public double getBalance(){
        return balance;
    }
}
public class EighthCode {
    public static void main(String[] args) {
        BanAcc obj = new BanAcc(2000.00);
        
        obj.deposit(500.00);
        obj.withdraw(500.00);
        obj.withdraw(15000.00);
        obj.deposit(500.00);

        System.out.println("Final Balance:" + obj.getBalance());

        
    }
}
