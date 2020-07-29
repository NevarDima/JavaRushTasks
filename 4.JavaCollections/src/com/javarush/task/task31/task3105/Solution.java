package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        String fileName = args[0].substring(args[0].lastIndexOf("/")+1);
        boolean createNewDirectory = true;

        Map<String, ByteArrayOutputStream> mapNamesAndBytes = new HashMap<>();

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null){;
            ByteArrayOutputStream data = new ByteArrayOutputStream();
            byte[] readBytes = new byte[1024];
            int readCount;
            while ((readCount = zipInputStream.read(readBytes))!=-1){
                data.write(readBytes, 0, readCount);
            }
            if(!fileName.equals(zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/")+1))) {
                mapNamesAndBytes.put(zipEntry.getName(), data);
            }else{
                createNewDirectory = false;
                fileName = zipEntry.getName();
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();


        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));

        if(createNewDirectory) {
            zipOutputStream.putNextEntry(new ZipEntry("new/" + fileName));
        }else{
            zipOutputStream.putNextEntry(new ZipEntry(fileName));
        }
        Files.copy(Paths.get(args[0]), zipOutputStream);
        zipOutputStream.closeEntry();
        for(Map.Entry<String,ByteArrayOutputStream> pair : mapNamesAndBytes.entrySet()){
            zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
            zipOutputStream.write(pair.getValue().toByteArray());
            zipOutputStream.closeEntry();
        }
        zipOutputStream.close();

    }
}
