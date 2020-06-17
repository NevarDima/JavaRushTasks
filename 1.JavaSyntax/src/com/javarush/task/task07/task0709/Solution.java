package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
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

        int minSize = strings.get(0).length();

        for (String string : strings) {
            if (string.length() < minSize) {
                minSize = string.length();
            }
        }

        for (String string : strings) {
            if (string.length() == minSize) {
                System.out.println(string);
            }
        }
    }
}
