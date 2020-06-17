package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream baot = new ByteArrayOutputStream();
        PrintStream outputStream  = new PrintStream(baot);
        System.setOut(outputStream);

        testString.printSomething();

        String result = baot.toString();
        System.setOut(consoleStream);

        String[] nums = result.split(" ");
        int res = 0;
        if(nums[1].equals("-")){
            res = Integer.parseInt(nums[0])-Integer.parseInt(nums[2]);
        }else if(nums[1].equals("+")){
            res = Integer.parseInt(nums[0])+Integer.parseInt(nums[2]);
        }else if(nums[1].equals("*")){
            res = Integer.parseInt(nums[0])*Integer.parseInt(nums[2]);
        }else if(nums[1].equals("/")){
            res = Integer.parseInt(nums[0])/Integer.parseInt(nums[2]);
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(i!=nums.length-2) {
                System.out.print(nums[i] + " ");
            }else{
                System.out.print(nums[i] + " " + res);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

