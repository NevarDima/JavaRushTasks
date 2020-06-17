package com.javarush.task.task08.task0812;

import java.io.IOException;
import java.util.*;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 2, 2, 4, 4, 4, 4, 1, 3, 3));
        List<Integer> list = new ArrayList<>();
        List<Integer> value = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int countSameNum = 1;

        for (int i = 0; i < 10; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1).equals(list.get(i))){
                countSameNum++;
            }else{
                value.add(countSameNum);
                countSameNum = 1;
            }
            if(i == list.size()-1){
                value.add(countSameNum);
            }
        }
        Collections.sort(value);
        System.out.println(value.get(value.size()-1));
    }
}