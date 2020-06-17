package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String newString = "";

        char[] charArray = string.toCharArray();
        if(charArray[0]!=' '){
            charArray[0] = Character.toUpperCase(charArray[0]);
        }
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i-1]==' ' && charArray[i]!=' '){
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }

        for (char c : charArray) {
            newString = newString.concat(Character.toString(c));
        }
        System.out.println(newString);
    }
}
