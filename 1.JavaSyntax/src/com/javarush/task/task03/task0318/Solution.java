package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String year = bufferedReader.readLine();
        String name = bufferedReader.readLine();


        System.out.println(name + " захватит мир через " + year + " лет. Му-ха-ха!");

    }
}
