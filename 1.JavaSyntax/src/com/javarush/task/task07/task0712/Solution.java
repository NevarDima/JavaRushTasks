package com.javarush.task.task07.task0712;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        ArrayList<String> strings = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            strings.add(sc.nextLine());
        }

        int minSize = strings.get(0).length();
        int maxSize = 0;

        for (String string : strings) {
            if (string.length() > maxSize) {
                maxSize = string.length();
            }
            if (string.length() < minSize) {
                minSize = string.length();
            }
        }

        for (String string : strings){
            if(string.length() == minSize || string.length() == maxSize){
                System.out.println(string);
                break;
            }
        }
    }
}
