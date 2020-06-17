package com.javarush.task.task18.task1802;

/* 
Минимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(br.readLine());
        int min = fin.read();
        while(fin.available()>0){
            int data = fin.read();
            if(min>data){
                min = data;
            }
        }
        fin.close();
        System.out.println(min);
    }
}
