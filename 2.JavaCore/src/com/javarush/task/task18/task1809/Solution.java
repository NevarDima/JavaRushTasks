package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream fos = new FileOutputStream(br.readLine());
        List<Integer> list = new ArrayList<>();

        while (fis.available()>0){
            list.add(fis.read());
        }
        fis.close();

        for (int i = list.size()-1; i >= 0 ; i--) {
            fos.write(list.get(i));
        }
        fos.close();
    }
}
