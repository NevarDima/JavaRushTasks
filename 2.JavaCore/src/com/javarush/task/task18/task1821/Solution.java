package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1821/file.txt";
//        FileInputStream fis = new FileInputStream(file);
        FileInputStream fis = new FileInputStream(args[0]);
        Map<Integer, Integer> map = new HashMap<>();

        while(fis.available()>0){
            int readByte = fis.read();
            if(!map.containsKey(readByte)){
                map.put(readByte,1);
            }else{
                map.replace(readByte, map.get(readByte)+1);
            }
        }
        fis.close();

        List<Integer> arrayKeys = new ArrayList<>(map.keySet());
        Collections.sort(arrayKeys);
        for (int i = 0; i < arrayKeys.size(); i++) {
            char symbol = (char) ((int)arrayKeys.get(i));
            System.out.println(symbol + " " + map.get(arrayKeys.get(i)));
        }
    }
}
