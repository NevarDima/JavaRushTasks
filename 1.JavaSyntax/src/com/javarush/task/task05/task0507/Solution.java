package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        double sum = 0;
        double count = 0;
        while(true){
            int num = sc.nextInt();
            if(num==-1){
                break;
            }
            sum += num;
            count++;
        }
        System.out.println(sum/count);
    }
}

