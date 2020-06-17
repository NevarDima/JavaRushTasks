package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String fileName = sc.nextLine();
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        List<Integer> evenNumbers = new ArrayList<>();


        try {
            fileInputStream = new FileInputStream(fileName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            int num;
            while(bufferedReader.ready()){
                if((num=Integer.parseInt(bufferedReader.readLine()))%2==0){
                    evenNumbers.add(num);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
        }

        Collections.sort(evenNumbers);
        for (Integer evenNumber : evenNumbers) {
            System.out.println(evenNumber);
        }
    }
}
