package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //add your code here
//        String line = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        String line = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = line.indexOf("?");
        String subLine = line.substring(index+1);


        String[] argumentsAndValues = subLine.split("&");
        List<String> values = new ArrayList<>();
        for (int i = 0; i < argumentsAndValues.length; i++) {
            String[] argValue = argumentsAndValues[i].split("=");
            System.out.print(argValue[0] + " ");
            if(argValue[0].equals("obj")){
                values.add(argValue[1]);
            }
        }
        System.out.println();

        for (String value : values) {
            try{
                alert(Double.parseDouble(value));
            }catch (Exception e){
                alert(value);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
