package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread spTh1 = new SpecialThread();
        SpecialThread spTh2 = new SpecialThread();
        SpecialThread spTh3 = new SpecialThread();
        SpecialThread spTh4 = new SpecialThread();
        SpecialThread spTh5 = new SpecialThread();
        Thread th1 = new Thread(spTh1);
        Thread th2 = new Thread(spTh2);
        Thread th3 = new Thread(spTh3);
        Thread th4 = new Thread(spTh4);
        Thread th5 = new Thread(spTh5);
        list.add(th1);
        list.add(th2);
        list.add(th3);
        list.add(th4);
        list.add(th5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
