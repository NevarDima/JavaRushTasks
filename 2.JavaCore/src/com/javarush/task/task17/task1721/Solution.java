package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        try{
            String fileName1 = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/file1.txt";
            String fileName2 = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task17/task1721/file2.txt";
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = br.readLine();
            fileName2 = br.readLine();

            br = new BufferedReader(new FileReader(fileName1));
            while (br.ready()){
                allLines.add(br.readLine());
            }
            br = new BufferedReader(new FileReader(fileName2));
            while (br.ready()){
                forRemoveLines.add(br.readLine());
            }
            br.close();

            solution.joinData();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException{
        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
