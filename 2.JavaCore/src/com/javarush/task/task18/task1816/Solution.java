package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        List<String> list = new ArrayList<>();
        int countEnLetters = 0;

        while (fis.available() > 0) {
            list.add(String.valueOf((char) fis.read()));
        }
        fis.close();

        for (String s : list) {
            if(s.matches("[A-Za-z]")){
                countEnLetters++;
            }
        }

        System.out.println(countEnLetters);
    }
}
