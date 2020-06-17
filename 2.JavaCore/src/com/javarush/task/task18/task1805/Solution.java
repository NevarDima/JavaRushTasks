package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        while(fis.available()>0){
            set.add(fis.read());
        }
        fis.close();

        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    }
}
