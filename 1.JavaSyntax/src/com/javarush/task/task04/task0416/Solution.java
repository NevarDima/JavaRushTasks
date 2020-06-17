package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        double i = sc.nextDouble();

        if(i%5.0<3){
            System.out.println("зеленый");
        }else if(i%5.0<4){
            System.out.println("желтый");
        }else if(i%5.0<5){
            System.out.println("красный");
        }
    }
}