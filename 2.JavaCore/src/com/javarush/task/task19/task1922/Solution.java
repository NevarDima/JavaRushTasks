package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

//    static {
//        words.add("А");
//        words.add("Б");
//        words.add("В");
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
//        String fileName = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1922/file.txt";
        br.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while(bufferedReader.ready()){
            String line = bufferedReader.readLine();
            String trimmedLine = line.trim();
            List<String> wordsInLine = new ArrayList<>(Arrays.asList(trimmedLine.split("([^а-яА-Яa-zA-Z0-9]+)")));
            int count = 0;
            for (String wordInLine : wordsInLine) {
                for (String word : words) {
                    if(wordInLine.equals(word)){
                        count++;
                    }
                }
            }
            if(count == 2){
                System.out.println(line);
            }
        }
        bufferedReader.close();
    }
}
