package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        try {
            while (true) {
                list.add(sc.nextInt());
            }
        }catch (Exception e){
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
