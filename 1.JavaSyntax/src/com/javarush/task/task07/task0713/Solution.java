package com.javarush.task.task07.task0713;

import java.util.ArrayList;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listDiv3 = new ArrayList<>();
        ArrayList<Integer> listDiv2 = new ArrayList<>();
        ArrayList<Integer> listAnother = new ArrayList<>();
        Scanner sc=new Scanner(System.in);

        for (int i = 0; i < 20; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%3==0){
                listDiv3.add(list.get(i));
            }
            if(list.get(i)%2==0){
                listDiv2.add(list.get(i));
            }
            if(list.get(i)%2!=0 && list.get(i)%3!=0){
                listAnother.add(list.get(i));
            }
        }

        printList(listDiv3);
        printList(listDiv2);
        printList(listAnother);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
