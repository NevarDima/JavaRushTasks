package com.javarush.task.task07.task0711;

/* 
Удалить и вставить
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            strings.add(sc.nextLine());
        }

        for (int i = 0; i < 13; i++) {
            strings.add(0, strings.remove(strings.size()-1));
        }

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
