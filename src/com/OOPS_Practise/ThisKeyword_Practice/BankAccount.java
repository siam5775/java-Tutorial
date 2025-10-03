package com.OOPS_Practise.ThisKeyword_Practice;

class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder,double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
        System.out.println("Name:" + accountHolder );
        System.out.println("Balance:" + balance );
    }

    public void deposit(double amount){
        this.balance = this.balance+amount;
        System.out.println("Deposit amount:"+ amount);
        System.out.println("Update Balance:"+ this.balance);
    }

    public void withdraw(double amount){
        if(balance>=amount){
            this.balance = this.balance-amount;
            System.out.println("withdraw:" + amount);
            System.out.println("Update Balance:" + this.balance);
        }else{
            System.out.println("Insuficient balance");
        }
    }

    public void accountHolder(){
        System.out.println("Name:" + accountHolder );
        System.out.println("Balance:" + balance );
    }
}

public class BankAccount{
    public static void main(String[] args) {
        Account obj = new Account("Siam", 0);
        obj.deposit(500);
        obj.withdraw(100);
        obj.accountHolder();
     }
}
