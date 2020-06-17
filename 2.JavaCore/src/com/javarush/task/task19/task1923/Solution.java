package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
//        FileReader fr = new FileReader("/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/file1.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(args[1]);
//        FileWriter fw = new FileWriter("/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1923/file2.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        while(br.ready()){
            String line = br.readLine();
            String[] wordsInLine = line.split(" ");
            for (String s : wordsInLine) {
                if(s.matches("([\\S]*[0-9]+[\\S]]*)")){
                    bw.write(s);
                    bw.write(" ");
                }
            }
        }
        br.close();
        fr.close();
        bw.close();
        fw.close();

    }
}
