package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        //"роза", "мера", "лоза", "лира", "вода", "упор"
        strings.add("роза");//-
        strings.add("лоза");//+
        strings.add("лира");
        strings.add("мера");//-
        strings.add("вода");
        strings.add("упор");//-
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        for (int i = 0; i < strings.size(); i++) {
            if(strings.get(i).contains("р") && !strings.get(i).contains("л")){
                strings.remove(i);
                if(i>0){
                    i--;
                    continue;
                }
            }
            if(!strings.get(i).contains("р") && strings.get(i).contains("л")){
                strings.add(i, strings.get(i));
                i++;
            }
        }
        return strings;
    }
}