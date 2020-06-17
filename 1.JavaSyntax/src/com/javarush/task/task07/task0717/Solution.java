package com.javarush.task.task07.task0717;

import java.util.ArrayList;
import java.util.Scanner;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextLine());
        }

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        for (String str : list){
            System.out.println(str);
        }
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            list.add(i, list.get(i));
            i++;
        }
        return list;
    }
}
