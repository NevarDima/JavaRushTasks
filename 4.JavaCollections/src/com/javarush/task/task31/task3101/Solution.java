package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFile = new File(args[1]);
        File renamedResultFile = new File(resultFile.getParent() + "\\allFilesContent.txt");
        FileUtils.renameFile(resultFile, renamedResultFile);

        File directory = new File(args[0]);
        FileWriter fw = new FileWriter(renamedResultFile, true);
        writeFiles(directory, fw);
        fw.close();

    }


    public static void writeFiles(File directory, FileWriter fw) throws IOException {
        File[] filesInDirectory = directory.listFiles();
        Arrays.sort(filesInDirectory);
        for (File file : filesInDirectory) {
            if(file.getName().endsWith(".txt") && file.length()<=50L){
                FileReader fr = new FileReader(file);
                while (fr.ready()) {
                    fw.write(fr.read());
                }
                fw.write('\n');
                fr.close();
            }else if(!file.getName().endsWith(".txt")){
                writeFiles(file, fw);
            }
        }
    }
}
