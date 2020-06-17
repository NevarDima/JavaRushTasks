package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int resPositive = 0;
        int resNegaive = 0;
        for (int i = 0; i < 3; i++) {
            int num = sc.nextInt();
            if(num>0){
                resPositive++;
            }else if(num<0){
                resNegaive++;
            }
        }
        System.out.println("количество отрицательных чисел: " + resNegaive +  ", количество положительных чисел: " + resPositive);

    }
}
