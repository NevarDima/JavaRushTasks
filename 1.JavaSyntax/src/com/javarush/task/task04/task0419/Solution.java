package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int maxAB = max(a,b);
        int maxCD = max(c,d);
        System.out.println(max(maxAB,maxCD));

    }

    public static int max(int a, int b){
        if(a>=b){
            return a;
        }else {
            return b;
        }
    }
}
