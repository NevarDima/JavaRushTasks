package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
//        String fileName = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1918/file.txt";
        br.close();
        String textFromFile = "";
        String openTag = "<" + args[0],closeTag = "</" + args[0] + ">";

        FileReader fr = new FileReader(fileName);
        while(fr.ready()) {
            textFromFile = textFromFile.concat(String.valueOf((char) fr.read()));
        }
        fr.close();

        LinkedList<Integer> openTagQueue = new LinkedList<>();
        LinkedList<String> printLineQueue = new LinkedList<>();

        for (int i = 0; i <= textFromFile.length()-closeTag.length(); i++) {
            if(textFromFile.substring(i).startsWith(openTag)){
                openTagQueue.add(i);
            }
            if(textFromFile.substring(i).startsWith(closeTag)){
                printLineQueue.add(textFromFile.substring(openTagQueue.removeLast(),i + closeTag.length()));
                if(openTagQueue.isEmpty()){
                    while(!printLineQueue.isEmpty()){
                        System.out.println(printLineQueue.removeLast());
                    }
                }
            }
        }
    }
}
