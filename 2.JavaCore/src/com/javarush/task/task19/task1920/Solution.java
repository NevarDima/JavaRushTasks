package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(args[0]);
        BufferedReader br = new BufferedReader(fr);
        TreeMap<String, Double> map = new TreeMap<>();
        double max = 0d;

        while(br.ready()){
            String line = br.readLine();
            String[] splitedLine = line.split(" ");
            if(!map.containsKey(splitedLine[0])){
                map.put(splitedLine[0], Double.parseDouble(splitedLine[1]));
                if(map.get(splitedLine[0])>max){
                    max = map.get(splitedLine[0]);
                }
            }else{
                map.replace(splitedLine[0],map.get(splitedLine[0]) + Double.parseDouble(splitedLine[1]));
                if(map.get(splitedLine[0])>max){
                    max = map.get(splitedLine[0]);
                }
            }
        }
        br.close();
        fr.close();

        for (Map.Entry<String, Double> pair : map.entrySet()){
            if(pair.getValue() == max){
                System.out.println(pair.getKey());
            }
        }
    }
}
