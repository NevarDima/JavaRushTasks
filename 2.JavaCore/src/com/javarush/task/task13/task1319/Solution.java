package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        BufferedWriter bufferedWriter = null;

        try{
            fileName = bufferedReader.readLine();
            bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            String line;
            do{
                line = bufferedReader.readLine();
                bufferedWriter.write(line + "\n");
            }while(!line.equals("exit"));

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }
}
