package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static boolean readNewFile = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (readNewFile){
            String fileName = br.readLine();
            if(!fileName.equals("exit")) {
                ReadThread readThread = new ReadThread(fileName);
            }else{
                readNewFile = false;
            }
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private int maxRepetitiveByte;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            Map<Integer, Integer> mapOfBytes = new HashMap<>();

            try {
                FileInputStream fis = new FileInputStream(fileName);
                int maxCount = 0;

                while(fis.available()>0){
                    int byteInFile = fis.read();

                    if(!mapOfBytes.containsKey(byteInFile)){
                        mapOfBytes.put(byteInFile,1);
                    }else{
                        mapOfBytes.replace(byteInFile, mapOfBytes.get(byteInFile)+1);
                        if(mapOfBytes.get(byteInFile)>maxCount){
                            maxCount = mapOfBytes.get(byteInFile);
                            maxRepetitiveByte = byteInFile;
                        }
                    }
                }

                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            synchronized (resultMap){
                resultMap.put(fileName,maxRepetitiveByte);
            }
        }
    }
}
