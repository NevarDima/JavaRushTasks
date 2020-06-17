package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try(FileReader fr = new FileReader(Statics.FILE_NAME)){
            int byteCount = 0;
            String line = "";
            while ((byteCount = fr.read())!=-1){
                String character = String.valueOf((char)byteCount);
                if(character.equals("\n")){
                    lines.add(line);
                    line = "";
                }else {
                    line = line.concat(character);
                    if(!fr.ready()){
                        lines.add(line);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
