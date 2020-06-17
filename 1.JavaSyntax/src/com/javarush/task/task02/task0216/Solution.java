package com.javarush.task.task02.task0216;

/* 
Минимум трёх чисел
*/
public class Solution {
    public static int min(int a, int b, int c) {
        //напишите тут ваш код
        int m2;
        if(a<b){
            m2 = a;
        }else{
            m2 = b;
        }
        int m3;
        if(m2<c){
            m3 = m2;
        }else{
            m3 = c;
        }
        return m3;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}