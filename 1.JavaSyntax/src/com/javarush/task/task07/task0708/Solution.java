package com.javarush.task.task07.task0708;

import java.util.ArrayList;
import java.util.Scanner;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        strings = new ArrayList<>();
        ArrayList<Integer> listOfBiggestStrings = new ArrayList<>();
        int maxSizeOfString = 0;

        for (int i = 0; i < 5; i++) {
            strings.add(sc.nextLine());
            if(strings.get(i).length()>maxSizeOfString){
                maxSizeOfString = strings.get(i).length();
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            if(strings.get(i).length() == maxSizeOfString){
                System.out.println(strings.get(i));
            }
        }
    }
}
