package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(br.readLine());
        int max = fin.read();
        while(fin.available()>0){
            int data = fin.read();
            if(data>max){
                max=data;
            }
        }
        fin.close();
        System.out.println(max);
    }
}
