package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            if(isInterrupted()){
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while(true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        boolean isAlive = true;
        @Override
        public void run() {
            while(isAlive){}
        }

        @Override
        public void showWarning() {
            isAlive = false;
        }
    }

    public static class Thread5 extends Thread{
        public int sum;
        Scanner sc=new Scanner(System.in);
        String line;

        @Override
        public void run() {
            while(!(line=sc.nextLine()).equals("N")){
                sum+=Integer.parseInt(line);
            }
            System.out.println(sum);
        }
    }
}