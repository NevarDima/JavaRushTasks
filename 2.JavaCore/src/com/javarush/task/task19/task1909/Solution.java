package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        br.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
        while (bufferedReader.ready()){
            int byteFromFile = bufferedReader.read();
            if(byteFromFile != (int) '.'){
                bufferedWriter.write(byteFromFile);
            }else {
                bufferedWriter.write("!");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
