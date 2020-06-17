package com.javarush.task.task06.task0610;

/* 
Класс ConsoleReader
*/

import java.util.Scanner;

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        return line;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        return i;
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        double i = sc.nextDouble();
        return i;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        return Boolean.parseBoolean(line);
    }

    public static void main(String[] args) throws Exception {

    }
}
