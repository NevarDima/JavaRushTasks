package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
//        String fileName = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1926/file.txt";
        br.close();

        FileReader fr = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fr);
        while (bufferedReader.ready()){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bufferedReader.readLine());
            System.out.println(stringBuilder.reverse());
        }
        bufferedReader.close();
        fr.close();
    }
}
