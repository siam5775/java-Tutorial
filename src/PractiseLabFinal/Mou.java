package PractiseLabFinal;

class Calculator {
    int number;

    
    public Calculator(int number) {
        this.number = number;
    }

    
    public void operate(int x) {
        int result = number + x;
        System.out.println(result);
    }

    
    public void operate(int x, int y) {
        int result = (y - x) + number;
        System.out.println(result);
    }
}

public class Mou {
    public static void main(String[] args) {
        Calculator obj = new Calculator(20);
        obj.operate(5);      // prints 25
        obj.operate(5, 10);  // prints 25
    }
}

