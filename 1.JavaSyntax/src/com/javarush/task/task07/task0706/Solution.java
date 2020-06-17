package com.javarush.task.task07.task0706;

import java.io.IOException;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        int[] arr = new int[15];
        int chet = 0;
        int nechet = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if(i%2==0){
                chet+=arr[i];
            }else{
                nechet+=arr[i];
            }
        }
        if(chet>nechet){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }else{
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
    }
}
