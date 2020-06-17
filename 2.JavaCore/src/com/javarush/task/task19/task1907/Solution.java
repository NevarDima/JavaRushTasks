package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        FileReader fr = new FileReader(fileName);
        String textInFile = "";
        while(fr.ready()){
            textInFile = textInFile.concat(String.valueOf((char) fr.read()));
        }
        fr.close();

        List<String> words = new ArrayList<>(Arrays.asList(textInFile.split("\\W+")));
        int count = 0;
        for (String word : words) {
            if(word.equals("world")){
                count++;
            }
        }
        System.out.println(count);
    }
}
