package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = new FileInputStream(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        while(fin.available()>0){
            int byteInFile = fin.read();
            if(!map.containsKey(byteInFile)){
                map.put(byteInFile,1);
            }else{
                map.replace(byteInFile,map.get(byteInFile),map.get(byteInFile)+1);
            }
        }
        fin.close();

        int maxCountOfBytes = 1;

        for (Map.Entry<Integer,Integer> pair: map.entrySet()) {
            if(pair.getValue() > maxCountOfBytes){
                maxCountOfBytes = pair.getValue();
            }
        }

        for (Map.Entry<Integer,Integer> pair: map.entrySet()) {
            if(pair.getValue() == maxCountOfBytes) {
                maxCountOfBytes = pair.getValue();
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
