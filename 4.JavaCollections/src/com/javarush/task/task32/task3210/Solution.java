package com.javarush.task.task32.task3210;

/* 
Используем RandomAccessFile
*/

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Solution {
    public static void main(String... args) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(args[0],"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] buffer = new byte[args[2].getBytes().length];
        if(raf != null){
            try{
                raf.seek(Long.parseLong(args[1]));
                raf.read(buffer,0,args[2].getBytes().length);
                if(Arrays.equals(buffer,args[2].getBytes())){
                    raf.seek(raf.length());
                    raf.setLength(raf.length() + "true".getBytes().length);
                    raf.write("true".getBytes());
                }else{
                    raf.seek(raf.length());
                    raf.setLength(raf.length() + "false".getBytes().length);
                    raf.write("false".getBytes());
                }
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
