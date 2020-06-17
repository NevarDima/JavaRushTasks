package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        TreeMap<String, Double> map = new TreeMap<>();

        while(br.ready()){
            String line = br.readLine();
            String[] splitedLine = line.split(" ");
            if(!map.containsKey(splitedLine[0])){
                map.put(splitedLine[0],Double.parseDouble(splitedLine[1]));
            }else{
                map.replace(splitedLine[0],map.get(splitedLine[0]) + Double.parseDouble(splitedLine[1]));
            }
        }
        br.close();
        fr.close();

        for(Map.Entry<String,Double> pair : map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
