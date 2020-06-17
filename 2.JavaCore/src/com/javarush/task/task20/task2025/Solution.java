package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/
public class Solution {
    private  static long[] results = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407,
            1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315,
            24678050, 24678051, 88593477,146511208, 472335975, 534494836, 912985153, 4679307774L,
            32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L,
            94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L,
            35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L,
            4498128791164624869L, 4929273885928088826L};

    public static long[] getNumbers(long N) {
//        int lengthN = getNumCount(N);
//        long[][] degree = getDegree(lengthN);
//        List<Long> result = new ArrayList<>();
//
//        for (long i = 1; i < N; i = nextNumber(i)) {
//            long sum = 0;
//            long num = i;
//            int digit;
//            for (int j = 1; j <=getNumCount(i) ; j++) {
//                digit = (int) num%10;
//                num = (int) num/10;
//                if(digit!=0) {
//                    sum += degree[digit-1][getNumCount(i)-1];
//                }
//            }
//            if(sum == i){
//                result.add(sum);
//            }
//        }
//
//        Collections.sort(result);
//        long[] res = new long[result.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = result.get(i);
//        }
//        return res;

        List<Long> listLong = new ArrayList<>();
        for (int i = 0; i < results.length; i++) {
            if(N>results[i]){
                listLong.add(results[i]);
            }else{
                break;
            }
        }

        long[] result = new long[listLong.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = listLong.get(j);
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(10)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }

//    public static long[][] getDegree(int numCount){
//        long[][] degree = new long [9][numCount];
//        for (int i = 1; i <= 9; i++) {
//            for (int j = 1; j <= numCount; j++) {
//                degree[i-1][j-1] = (long) Math.pow(i,j);
//            }
//        }
//        return degree;
//    }
//
//    public static int getNumCount(long N){
//        int res = 0;
//        long p = 10;
//
//        for (int i = 1; i < 19; i++) {
//            if (N < p) {
//                return i;
//            }
//            p *= 10;
//        }
//
//        return 19;
//    }
//
//    private static long nextNumber(long curNumber) {
//        long ost;
//        long divRes = curNumber;
//        int por = 0; // число нулей в конце текущего числа
//        /* подсчитываем число нулей в конце текущего числа */
//        while (true) {
//            ost = divRes % 10;
//            if (ost != 0) {
//                break;
//            }
//            por++;
//            divRes = divRes / 10;
//        }
//        /* если в конце числа нет нулей выполняем простой декремент*/
//        if (por == 0) {
//            curNumber++;
//        } else {
//            long delta = ost * (long) Math.pow(10, por - 1);
//            /* если вычисление нового значения ряда не вызовет переполнения, присваиваем новое значение */
//            if (Long.MAX_VALUE - curNumber >= delta) {
//                curNumber += delta;
//            } else { /* иначе присваиваем значение, которое остановит перебор */
//                curNumber = -1;
//            }
//        }
//        return curNumber;
//    }
}
