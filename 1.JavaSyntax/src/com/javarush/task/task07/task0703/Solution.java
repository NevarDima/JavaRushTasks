package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] arrStr = new String[10];
        int[] arrInt = new int[10];
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            arrStr[i] = sc.nextLine();
            arrInt[i] = arrStr[i].length();
            System.out.println(arrInt[i]);
        }
    }
}
