package com.Mid;

public class Product {
    int id;
    String productName;
    int quantity;

    // Constructor
    Product(int id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Method to store (add) quantity
    void productStore(int quantity) {
        this.quantity += quantity;
        System.out.println(quantity + " items added. New quantity: " + this.quantity);
    }

    // Method to subtract quantity
    void productSubstract(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " items removed. New quantity: " + this.quantity);
        } else {
            System.out.println("Not enough stock to remove " + quantity + " items!");
        }
    }

    // Method to show product details
    void productDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name: " + productName);
        System.out.println("Available Quantity: " + quantity);
    }

    // Main method
    public static void main(String[] args) {
        // Create product object
        Product p1 = new Product(101, "Laptop", 10);

        // Show details
        p1.productDetails();

        // Store items
        p1.productStore(5);

        // Subtract items
        p1.productSubstract(3);

        // Final details
        p1.productDetails();
    }
}

