package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isWork = true;

        while (isWork){
            String fileName = br.readLine();
            try(FileInputStream fis = new FileInputStream(fileName)){

            }catch (FileNotFoundException e){
                System.out.println(fileName);
                isWork = false;
            }
        }


    }


}
