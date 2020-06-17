package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        BufferedReader input = new BufferedReader(new FileReader(fileName));
        List<String> list = new ArrayList<>();
        while (input.ready()){
            String line = input.readLine();
            if(args.length>0 && args[1].equals(line.substring(0,8).trim())){
                if(args[0].equals("-u")){
                    String productName = String.format("%-30.30s", args[2]);
                    String price = String.format("%-8.2f", Double.parseDouble(args[3]));
                    String quantity = String.format("%-4d", Integer.parseInt(args[4]));
                    String appendLine = line.substring(0,8).concat(productName).concat(price).concat(quantity);
                    list.add(appendLine);
                }else if(args.length == 2 && args[0].equals("-d")){
                    continue;
                }
            }else{
                list.add(line);
            }
        }
        input.close();


        FileOutputStream fos = new FileOutputStream(fileName);
        for(String line : list){
            fos.write(line.getBytes());
            fos.write('\n');
        }
        fos.close();
    }
}
