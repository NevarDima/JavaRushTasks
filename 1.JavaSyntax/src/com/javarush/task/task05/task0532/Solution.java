package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int countNum = sc.nextInt();

        if (countNum>0){
            for (int i = 0; i < countNum; i++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            System.out.println(list.get(countNum-1));
        }
    }
}
