package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Arrays.sort(args,1,args.length);
        Vector<FileInputStream> vectorFIS = new Vector<>();
        for (int i = 1; i < args.length; i++) {
            vectorFIS.add(new FileInputStream(args[i]));
        }

        Enumeration<FileInputStream> enumerationFIS = vectorFIS.elements();

        SequenceInputStream sequenceInputStream = new SequenceInputStream(enumerationFIS);

        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);

        ZipEntry zipEntry;
        while((zipEntry = zipInputStream.getNextEntry()) !=null) {
            byte[] readBytes = new byte[1024 * 1024];
            int byteBuffer;
            while((byteBuffer = zipInputStream.read(readBytes)) != -1){
                fileOutputStream.write(readBytes,0,byteBuffer);
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
        fileOutputStream.close();
    }
}
