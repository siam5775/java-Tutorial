package com.OOPS_Practise.Inheritance;

public class MainBankAccount {
    public static void main(String[] args) {
        BankAccount BA = new BankAccount("Siam",520, 10000);

        BA.diposit(5000);
        BA.withdraw(2000);

        SavingsAccount SA = new SavingsAccount("Siam", 521, 5000);

        SA.withdraw(1000);
        SA.SavingsAccountDetails();

    }
}
