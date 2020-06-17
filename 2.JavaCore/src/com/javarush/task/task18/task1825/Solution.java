package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> fileNames = new ArrayList<>();
        String name;
        while (!(name = br.readLine()).equals("end")){
            fileNames.add(name);
        }
        Collections.sort(fileNames);

        FileOutputStream fos = new FileOutputStream(fileNames.get(0).substring(0, fileNames.get(0).lastIndexOf(".part")));
        for (String fileName : fileNames) {
            FileInputStream fis = new FileInputStream(fileName);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
            fis.close();
        }
        fos.close();
    }
}
