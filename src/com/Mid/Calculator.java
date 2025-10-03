package com.Mid;
class Calculator {
    int value;

    Calculator(int value) {
        this.value = value;
    }

    // Subtract integer
    void subtract(int num) {
        value -= num;
        System.out.println("After subtracting int: " + value);
    }

    // Subtract double
    void subtract(double num) {
        value -= num;
        System.out.println("After subtracting double: " + value);
    }

    // Subtract two numbers
    void subtract(int num1, int num2) {
        value -= (num1 + num2);
        System.out.println("After subtracting two numbers: " + value);
    }

    void display() {
        System.out.println("Current value: " + value);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(50);
        calc.display();         // 50
        calc.subtract(10);      // 50-10 = 40
        calc.subtract(5.5);     // 40-5.5 = 34
        calc.subtract(2, 3);    // 34-5 = 29
        calc.display();         // 29
    }
}
