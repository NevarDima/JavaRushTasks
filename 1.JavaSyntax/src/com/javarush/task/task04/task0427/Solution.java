package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        if (i<1000 && i>0){
            System.out.println(numIsEvenOrOdd(i) + numOfDigits(i) + "число");
        }


    }

    public static String numIsEvenOrOdd(int num){
        if(num%2==0){
            return "четное ";
        }else{
            return "нечетное ";
        }
    }

    public static String numOfDigits(int num){
        int numOfDigits = (Integer.toString(num)).length();
        if(numOfDigits==3){
            return "трехзначное ";
        }else if(numOfDigits==2){
            return "двузначное ";
        }else if(numOfDigits==1 && num !=0){
            return "однозначное ";
        }
        return "число не соответствует условию задачи";
    }
}
