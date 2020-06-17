package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner sc=new Scanner(System.in);
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        System.out.println(list.get(1));


    }
}
