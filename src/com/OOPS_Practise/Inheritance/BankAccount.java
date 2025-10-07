package com.OOPS_Practise.Inheritance;

public class BankAccount {
    String name;
    int accno;
    double balance;

    public BankAccount(String name,int accno,double balance){
        this.name = name;
        this.accno = accno;
        this.balance = balance;
        System.out.println("Name:" + name);
        System.out.println("ACC NO:" + accno);
        System.out.println("Balance:" + balance);
    }

    void diposit(double amount){
        if(amount>0){
            System.out.println("After Diposit balance is:" + (balance+amount));
        }
    }

    void withdraw(double amount){
        if(balance>0){
           if(balance>amount){
            System.out.println("After Withdraw balance is:" + (balance-amount));
           }
        }else{
            System.out.println("Insuficient Balance");
        }
    }

    void AccountDetails(){
        System.out.println("Name:" + name);
        System.out.println("ACC NO:" + accno);
        System.out.println("Balance:" + balance);
    }
}

class SavingsAccount extends BankAccount{

    public SavingsAccount(String name,int accno,double balance){
        super(name,accno,balance);
    }
    
    @Override
    void withdraw(double amount){
        if(balance>100){
            System.out.println("After withdraw Savings AC balance is:" + (balance-=amount));
        }else{
            System.out.println("Not overridie this method");
        }
    }

    void SavingsAccountDetails(){
        System.out.println("Name:" + name);
        System.out.println("ACC NO:" + accno);
        System.out.println("Balance:" + (balance));
    }
}