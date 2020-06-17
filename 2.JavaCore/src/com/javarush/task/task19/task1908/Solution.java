package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileNameForRead = "";
        String fileNameForWrite = "";
        try {
            fileNameForRead = br.readLine();
            fileNameForWrite = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String textInFile = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameForRead));
            while (bufferedReader.ready()) {
                textInFile = textInFile.concat(bufferedReader.readLine()).concat(" ");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = textInFile.split(" ");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileNameForWrite));
            for (String word : words) {
                if(word.matches("(-)?[0-9]+([,.][0-9]+)?")){
                    bufferedWriter.write(word + " ");
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
