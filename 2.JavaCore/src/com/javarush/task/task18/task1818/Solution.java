package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream(br.readLine(),true);
        FileInputStream fis1 = new FileInputStream(br.readLine());
        FileInputStream fis2 = new FileInputStream(br.readLine());

        while(fis1.available()>0){
            fos.write(fis1.read());
        }
        fis1.close();

        while(fis2.available()>0){
            fos.write(fis2.read());
        }
        fis2.close();
        fos.close();
    }
}
