package com.ContestQus;

import java.util.*;

public class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};  
                }
            }
        }
        return new int[]{}; 
    }
    
    public static void main(String[] args) {
        leetcode1 sol  = new leetcode1();

        int[] num1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = sol.twoSum(num1, target1);
        System.out.println(Arrays.toString(result1));

        int[] num2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = sol.twoSum(num2, target2);
        System.out.println(Arrays.toString(result2));

        int[] num3 = {3, 3};
        int target3 = 6;
        int[] result3 = sol.twoSum(num3, target3);
        System.out.println(Arrays.toString(result3));
    }
}
