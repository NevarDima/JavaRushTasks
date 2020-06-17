package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();
//        String fileName = "/Users/Dima/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1827/file.txt";
        int maxId = getLastId(fileName);
        String appendLine = "";


        if(args.length == 4 && args[0].equals("-c")){
            String id = String.format("%-8d", ++maxId);
            String productName = String.format("%-30.30s", args[1]);
            String price = String.format("%-8.2f", Double.parseDouble(args[2]));
            String quantity = String.format("%-4d", Integer.parseInt(args[3]));
            appendLine=appendLine.concat(id).concat(productName).concat(price).concat(quantity);

            FileOutputStream fos = new FileOutputStream(fileName, true);
            fos.write((int) '\n');
            fos.write(appendLine.getBytes());
            fos.close();

        }
    }

    public static int getLastId(String fileName) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line;
        int maxId = 0;
        while (input.ready()){
            line = input.readLine().substring(0,8).trim();
            if(Integer.parseInt(line)>maxId){
                maxId = Integer.parseInt(line);
            }
        }
        input.close();
        return maxId;
    }
}
