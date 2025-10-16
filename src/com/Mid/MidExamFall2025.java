package com.Mid;

    public class MidExamFall2025 {
    public static void main(String[] args) {
        int x = 6, y, z, d = 2;

        y = x++;        // Post-increment: y = 6, x = 7
        z = ++y;        // Pre-increment: y = 7 → z = 7+1 = 8

        System.out.println("Step 1:\n x=" + x + ", y=" + y + ", z=" + z);

        int a = z-- * ++x - y--;   // Step by step below
        int b = (a > z) ? a & z : a | z;
        int c = (x % 2 == 0) ? b ^ y : b+x;

        System.out.println("Step 2: c = " + c);

        d = d++;  // Post increment (d = 2 first, then becomes 3 after statement)

        System.out.println("Step 3: Final Result = " + c / d);
    }
}
