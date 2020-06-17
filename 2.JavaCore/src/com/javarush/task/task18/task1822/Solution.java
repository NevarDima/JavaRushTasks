package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        br = new BufferedReader(new InputStreamReader(fis));

        while (br.ready()){
            String line = br.readLine();
            if(line.startsWith(args[0]+" ")){
                System.out.println(line);
            }
        }
        fis.close();
    }
}
