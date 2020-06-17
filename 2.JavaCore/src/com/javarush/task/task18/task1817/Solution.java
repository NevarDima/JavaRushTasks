package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int countAllSymbols = 0;
        int countSpaces = 0;
        String file = "";

        while(fis.available()>0){
            file = file.concat(String.valueOf((char) fis.read()));
        }
        fis.close();

        countAllSymbols = file.length();
        file = file.replaceAll(" ","");
        countSpaces = countAllSymbols - file.length();

        System.out.println(Math.round((((double) countSpaces/countAllSymbols))*100*100.0)/100.0);
    }
}
