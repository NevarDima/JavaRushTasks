package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> buffer = new ArrayList<>();
        String file1 = br.readLine();
        String file2 = br.readLine();

        FileInputStream fis1 = new FileInputStream(file1);

        while(fis1.available()>0){
            buffer.add(fis1.read());
        }
        fis1.close();

        FileOutputStream fos = new FileOutputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        while (fis2.available()>0){
            fos.write(fis2.read());
        }
        fis2.close();
        for (Integer integer : buffer) {
            fos.write(integer);
        }
        fos.close();
    }
}
