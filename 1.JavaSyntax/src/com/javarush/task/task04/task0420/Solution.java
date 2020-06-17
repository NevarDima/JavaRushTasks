package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc=new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        System.out.println(list.get(2)+" "+list.get(1)+" "+list.get(0));
    }
}
