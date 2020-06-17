package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream baot = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baot);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String[] println = baot.toString().split("\n");
        for (int i = 0; i < println.length; i++) {
            if((i+1)%2==0){
                System.out.println(println[i]);
                System.out.println("JavaRush - курсы Java онлайн");
            }else{
                System.out.println(println[i]);
            }
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
