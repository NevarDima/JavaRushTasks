package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream baot = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(baot);
        System.setOut(outputStream);

        testString.printSomething();

        String result = baot.toString();

        System.setOut(consoleStream);

        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(result.getBytes());
        fos.close();

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

