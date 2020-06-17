package com.javarush.task.task05.task0529;

/* 
Консоль-копилка
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true){
            String line = br.readLine();
            if (line.equals("сумма")){
                System.out.println(sum);
                break;
            }
            sum+=Integer.parseInt(line);
        }
    }
}
