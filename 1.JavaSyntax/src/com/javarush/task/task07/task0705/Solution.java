package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] arr = new int[20];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = arr[i];
            arr2[i] = arr[i+10];
            System.out.println(arr2[i]);
        }
    }
}
