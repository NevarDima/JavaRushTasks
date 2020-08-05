package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(args[0],"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (raf != null){
            try {
                if(raf.length() > Long.parseLong(args[1])) {
                    raf.seek(Long.parseLong(args[1]));
                }else{
                    raf.seek(raf.length());
                    raf.setLength(raf.length() + args[2].getBytes().length);
                }
                raf.write(args[2].getBytes());
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
