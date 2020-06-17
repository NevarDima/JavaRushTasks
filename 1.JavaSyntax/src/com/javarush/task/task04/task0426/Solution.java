package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();

        if(i==0){
            System.out.println("ноль");
        }else if(i<0 && i%2==0){
            System.out.println("отрицательное четное число");
        }else if(i<0 && i%2!=0){
            System.out.println("отрицательное нечетное число");
        }else if(i>0 && i%2==0){
            System.out.println("положительное четное число");
        }else if(i>0 && i%2!=0){
            System.out.println("положительное нечетное число");
        }

    }
}
