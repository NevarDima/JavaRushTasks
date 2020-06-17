package com.javarush.task.task07.task0714;

/* 
Слова в обратном порядке
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> words = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            words.add(sc.nextLine());
        }

        words.remove(2);

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(words.size()-i-1));
        }
    }
}
