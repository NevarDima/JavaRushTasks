package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream fos1 = new FileOutputStream(br.readLine());
        FileOutputStream fos2 = new FileOutputStream(br.readLine());

        int countAvailable = fis.available();

        while (fis.available()>0){
            if(fis.available()>countAvailable/2){
                fos1.write(fis.read());
            }else{
                fos2.write(fis.read());
            }
        }
        fis.close();
        fos1.close();
        fos2.close();
    }
}
