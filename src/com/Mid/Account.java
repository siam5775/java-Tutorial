package com.Mid;

public class Account {
    int id;         // অ্যাকাউন্ট আইডি
    String name;    // অ্যাকাউন্ট হোল্ডারের নাম
    double balance; // অ্যাকাউন্ট ব্যালেন্স

    // Constructor: নতুন অ্যাকাউন্ট তৈরি করার সময় ব্যবহার হবে
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Deposit method: টাকা জমা দেওয়া
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " টাকা জমা হয়েছে।");
        } else {
            System.out.println("টাকার পরিমাণ ধনাত্মক হতে হবে।");
        }
    }

    // Withdraw method: টাকা উত্তোলন করা
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println(amount + " টাকা উত্তোলন হয়েছে।");
            } else {
                System.out.println("ব্যালেন্স যথেষ্ট নেই।");
            }
        } else {
            System.out.println("টাকার পরিমাণ ধনাত্মক হতে হবে।");
        }
    }

    // Account details দেখানোর method
    public void accountDetails() {
        System.out.println("----- Account Details -----");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
        System.out.println("---------------------------");
    }

    // Main method: প্রোগ্রাম শুরু এখান থেকে
    public static void main(String[] args) {
        // নতুন অ্যাকাউন্ট তৈরি
        Account myAccount = new Account(101, "Siyam Ahmed", 5000);

        // প্রাথমিক অ্যাকাউন্ট তথ্য দেখানো
        myAccount.accountDetails();

        // Deposit করা
        myAccount.deposit(2000);

        // Withdraw করা
        myAccount.withdraw(1500);

        // চূড়ান্ত অ্যাকাউন্ট তথ্য দেখানো
        myAccount.accountDetails();
    }
}
