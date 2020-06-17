package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        int a = 0;
        int b = 0;
        while(a<10){
            a++;
            while(b<10){
                b++;
                System.out.print(a*b + " ");
            }
            b = 0;
            System.out.println();
        }
    }
}
