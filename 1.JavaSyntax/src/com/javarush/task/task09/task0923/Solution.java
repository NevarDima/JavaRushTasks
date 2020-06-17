package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        List<Character> vowelsInLine = new ArrayList<>();
        List<Character> consonantsInLine = new ArrayList<>();
        char[] charsInLine;

        line = line.replaceAll(" ", "");
        charsInLine = line.toCharArray();
        for (char c : charsInLine) {
            if (isVowel(c)) {
                vowelsInLine.add(c);
            } else {
                consonantsInLine.add(c);
            }
        }

        for (Character character : vowelsInLine) {
            System.out.print(character + " ");
        }
        System.out.println();
        for (Character character : consonantsInLine){
            System.out.print(character + " ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}