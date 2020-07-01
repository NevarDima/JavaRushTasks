package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;

/* 
Что внутри папки?
*/
public class Solution {

    public static int numOfDirectory = -1;
    public static int numOfFiles;
    public static long sumSize;

    public static void main(String[] args) throws IOException {
        SearchFileVisitor sfv = new SearchFileVisitor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Path startDirectory = Paths.get(br.readLine());
        br.close();

        if(!Files.isDirectory(startDirectory)){
            System.out.println(startDirectory.toString() + " - не папка");
            return;
        }

        Files.walkFileTree(startDirectory, sfv);
        System.out.println("Всего папок - " + numOfDirectory);
        System.out.println("Всего файлов - " + numOfFiles);
        System.out.println("Общий размер - " + sumSize);
    }
}
