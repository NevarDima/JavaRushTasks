package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int sum = 0;
        int num = number;
        for (int i = 0; i < 3; i++) {
            sum += num%10;
            num =num/10;
        }
        return sum;



    }
}