package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        int count = 0;
        char c = ',';

        while(fis.available()>0){
            if((int) c == fis.read()){
                count++;
            }
        }
        fis.close();

        System.out.println(count);
    }
}
