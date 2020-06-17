package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());

        if (num1<1 || num2<1){
            throw new Exception();
        }

        int res;
        while(num2!=0){
            res = num1%num2;
            num1 = num2;
            num2 = res;

        }
        System.out.println(num1);
    }
}
