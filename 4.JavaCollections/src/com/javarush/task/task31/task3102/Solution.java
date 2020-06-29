package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileNamesList = new ArrayList<>();
        File directory = new File(root);
        List<File> filesQueue = new LinkedList<>();
        filesQueue.add(directory);
        while(!filesQueue.isEmpty()){
            if(filesQueue.get(0).isDirectory()){
                filesQueue.addAll(Arrays.asList(filesQueue.remove(0).listFiles()));
            }else{
                fileNamesList.add(filesQueue.remove(0).getAbsolutePath());
            }
        }

        return fileNamesList;
    }

    public static void main(String[] args) {

    }
}
