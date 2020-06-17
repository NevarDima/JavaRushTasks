package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream fos = new FileOutputStream(br.readLine());
        String num = "";

        while (fis.available()>0){
            char buffer = (char) fis.read();
            if(buffer != ' '){
                num = num.concat(String.valueOf(buffer));
            }else{
                int number = (int)Math.round(Double.parseDouble(num));
                num = String.valueOf(number) + " ";
                fos.write(num.getBytes());
                num = "";
            }
        }
        if (!num.isEmpty()){
            int number = (int)Math.round(Double.parseDouble(num));
            num = String.valueOf(number) + " ";
            fos.write(num.getBytes());
            num = "";
        }
        fis.close();
        fos.close();
    }

}
