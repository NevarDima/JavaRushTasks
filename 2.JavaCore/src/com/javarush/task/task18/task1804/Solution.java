package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import sun.applet.resources.MsgAppletViewer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        while(fis.available()>0){
            int byteInFile = fis.read();
            if(!map.containsKey(byteInFile)){
                map.put(byteInFile,1);
            }else{
                map.replace(byteInFile,map.get(byteInFile)+1);
            }
        }
        fis.close();

        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if(pair.getValue()<minValue){
                minValue = pair.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if(pair.getValue() == minValue){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
