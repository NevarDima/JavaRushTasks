package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int sum = 0;
        while (true){
            int num = sc.nextInt();
            sum+=num;
            if(num==-1){
                break;
            }
        }
        System.out.println(sum);

    }
}
