package com.javarush.task.task07.task0702;

/* 
Массив из строчек в обратном порядке
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] array = new String[10];
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            array[i] = sc.nextLine();
        }

        for (int i = 9; i >=0 ; i--) {
            System.out.println(array[i]);
        }
    }
}