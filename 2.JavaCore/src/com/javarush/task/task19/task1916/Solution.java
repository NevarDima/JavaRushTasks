package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        FileReader fr1 = new FileReader(file1);
        BufferedReader bufferedReader1 = new BufferedReader(fr1);
        List<String> linesFile1 = new ArrayList<>();
        while(bufferedReader1.ready()){
            linesFile1.add(bufferedReader1.readLine());
        }
        fr1.close();

        FileReader fr2 = new FileReader(file2);
        BufferedReader bufferedReader2 = new BufferedReader(fr2);
        List<String> linesFile2 = new ArrayList<>();
        while(bufferedReader2.ready()){
            linesFile2.add(bufferedReader2.readLine());
        }
        fr2.close();

        while(linesFile1.size()>0 && linesFile2.size()>0){
            if(linesFile1.get(0).equals(linesFile2.get(0))){
                lines.add(new LineItem(Type.SAME, linesFile1.get(0)));
                linesFile1.remove(0);
                linesFile2.remove(0);
            } else {
                if(linesFile1.get(1).equals(linesFile2.get(0))){
                    lines.add(new LineItem(Type.REMOVED, linesFile1.get(0)));
                    linesFile1.remove(0);
                }else if(linesFile1.get(0).equals(linesFile2.get(1))){
                    lines.add(new LineItem(Type.ADDED, linesFile2.get(0)));
                    linesFile2.remove(0);
                }
            }
        }
        if(linesFile1.size()>0){
            for (int i = 0; i < linesFile1.size(); i++) {
                lines.add(new LineItem(Type.REMOVED, linesFile1.get(i)));
            }
        }
        if(linesFile2.size()>0){
            for (int i = 0; i < linesFile2.size(); i++) {
                lines.add(new LineItem(Type.ADDED, linesFile2.get(i)));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
