package com.javarush.task.task07.task0710;

/* 
В начало списка
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            strings.add(0, sc.nextLine());
        }

        for (String str : strings){
            System.out.println(str);
        }
    }
}
