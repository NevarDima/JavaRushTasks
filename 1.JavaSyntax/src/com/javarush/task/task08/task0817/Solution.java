package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<>();
        map.put("Lastname1","Firstname1");
        map.put("Lastname2","Firstname2");
        map.put("Lastname3","Firstname1");
        map.put("Lastname4","Firstname3");
        map.put("Lastname5","Firstname1");
        map.put("Lastname6","Firstname4");
        map.put("Lastname7","Firstname5");
        map.put("Lastname8","Firstname6");
        map.put("Lastname9","Firstname7");
        map.put("Lastname10","Firstname8");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> values = new ArrayList<>(map.values());
        ArrayList<String> valuesAfterDeleting = new ArrayList<>();
        for (String element : values){
            if(valuesAfterDeleting.contains(element)){
                removeItemFromMapByValue(map, element);
            }else{
                valuesAfterDeleting.add(element);
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        Map<String,String> map = createMap();
        removeTheFirstNameDuplicates(map);
//        for (Map.Entry<String, String> pair : map.entrySet()){
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }
    }
}
