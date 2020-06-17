package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;

        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            fileName = bf.readLine();
            fis = new FileInputStream(fileName);
            bis = new BufferedInputStream(fis);
            while(bis.available()>0){
                System.out.print((char)bis.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bis.close();
            fis.close();
            bf.close();
        }

    }
}