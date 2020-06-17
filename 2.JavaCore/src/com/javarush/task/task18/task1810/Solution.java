package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        boolean isBiggerThan1000 = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<FileInputStream> list = new ArrayList<>();


        while (isBiggerThan1000){
            FileInputStream fis = new FileInputStream(br.readLine());
            if(fis.available()<1000){
                fis.close();
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).close();
                }
                throw new DownloadException();
            }else{
                list.add(fis);
            }

        }
    }

    public static class DownloadException extends Exception {

    }
}
