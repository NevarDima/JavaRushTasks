package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
//        FileReader fr = new FileReader("/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1925/file1.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> list = new ArrayList<>();

        while(br.ready()){
            String line = br.readLine();
            list.addAll(Arrays.asList(line.split(" ")));
        }
        br.close();
        fr.close();

        FileWriter fw = new FileWriter(args[1]);
//        FileWriter fw = new FileWriter("/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task19/task1925/file2.txt");
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).length()>6){
                if(count == 0){
                    fw.write(list.get(i));
                    count++;
                }else{
                    fw.write("," + list.get(i));
                }

            }
        }
        fw.close();

    }
}
