package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,String> map = new HashMap<>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) {
                break;
            }

            map.put(city, reader.readLine());
        }

        // Read the house number
        String cityName = reader.readLine();

        for (Map.Entry<String,String> pair : map.entrySet()){
            if(pair.getKey().equals(cityName)){
                System.out.println(pair.getValue());
            }
        }
    }
}
