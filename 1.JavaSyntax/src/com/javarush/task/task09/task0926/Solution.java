package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[5]);
        listOfArrays.add(new int[2]);
        listOfArrays.add(new int[4]);
        listOfArrays.add(new int[7]);
        listOfArrays.add(new int[0]);
        for (int[] listArr : listOfArrays){
            for (int i = 0; i < listArr.length; i++) {
                listArr[i] = (int)Math.random();
            }
        }
        return listOfArrays;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
