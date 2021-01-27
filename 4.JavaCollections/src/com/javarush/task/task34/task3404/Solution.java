package com.javarush.task.task34.task3404;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0);
    }

    public void recurse(final String expression, int countOperation) {
        //implement
        String inExpression = expression.replaceAll("\\s", "");
        inExpression = inExpression.replaceAll("tan","t");
        inExpression = inExpression.replaceAll("sin","s");
        inExpression = inExpression.replaceAll("cos","c");
        NumberFormat numberFormat = new DecimalFormat("#.##");
        if(inExpression.matches("^-?\\d+(\\.\\d+)?")){
            if(inExpression.equals("-0")){
                inExpression = "0";
                countOperation++;
            }
            System.out.println(numberFormat.format(Double.parseDouble(inExpression)).replace(",",".") + " " + countOperation);
            return;
        }

        if(countOperation == 0){
            for (char ch : inExpression.toCharArray()){
                if(ch == 'c' || ch == 's' || ch == 't' || ch == '/' || ch == '*' || ch == '+' || ch == '-' || ch == '^'){
                    countOperation++;
                }
            }
        }

        String subExpression = inExpression;
        String leftPart = "";
        String rightPart = "";
        if(inExpression.contains("(")) {
            int indexLastOpenBracket = inExpression.lastIndexOf('(');
            int indexFirstCloseBracket = 0;
            for (int i = indexLastOpenBracket+1; i < inExpression.length(); i++) {
                if(inExpression.charAt(i) == ')'){
                    indexFirstCloseBracket = i;
                    break;
                }
            }
            subExpression = inExpression.substring(indexLastOpenBracket+1,indexFirstCloseBracket);
            leftPart = inExpression.substring(0,indexLastOpenBracket);
            rightPart = inExpression.substring(indexFirstCloseBracket+1);
        }


        List<String> operandString = new ArrayList<>(Arrays.asList(subExpression.split("[-+*^/]")));
        for (int i = 0; i < operandString.size(); i++) {
            if(operandString.get(i).equals("")){
                operandString.remove(i);
                operandString.set(i,"-"+operandString.get(i));
                if(operandString.get(i).equals("-")){
                    operandString.remove(i);
                }
            }
        }
        List<String> operation = new ArrayList<>(Arrays.asList(subExpression.split("[a-z]|\\d+\\.\\d+|[0-9]+")));
        if(!operation.isEmpty()){
            operation.remove(0);
            for (int i = 0; i < operation.size(); i++) {
                if(operation.get(i).equals("+-")){
                    operation.set(i,"+");
                }else if(operation.get(i).equals("/-")){
                    operation.set(i,"/");
                }else if(operation.get(i).equals("*-")){
                    operation.set(i,"*");
                }else if(operation.get(i).equals("--")){
                    operation.set(i,"-");
                }else if(operation.get(i).equals("^-")){
                    operation.set(i,"^");
                }else if(operation.get(i).equals("")){
                    operation.remove(i);
                }
            }
        }

        List<Double> operand = new ArrayList<>();
        for (int i = 0; i < operandString.size(); i++) {
            operand.add(Double.parseDouble(operandString.get(i)));
        }

        if(operation.contains("^")) {
            while (operation.contains("^")) {
                int index = operation.indexOf("^");
                double result;
                if(operand.get(index+1)>0) {
                    result = Math.pow(operand.get(index), operand.get(index + 1));
                }else if(operand.get(index+1)==0){
                    result = 1;
                }else{
                    if(operand.get(index)>=0) {
                        result = 1 / Math.pow(operand.get(index), operand.get(index + 1) * (-1));
                    }else{
                        result = -1 / Math.pow(operand.get(index), operand.get(index + 1) * (-1));
                    }
                }
                operand.set(index, result);
                operand.remove(index + 1);
                operation.remove(index);
            }
        }

        for (int i = 0; i < operation.size(); i++) {
            if(operation.get(i).equals("/")){
                double result = operand.get(i) / operand.get(i+1);
                operand.set(i, result);
                operand.remove(i + 1);
                operation.remove(i);
                i--;
            }else if(operation.get(i).equals("*")){
                double result = operand.get(i) * operand.get(i+1);
                operand.set(i, result);
                operand.remove(i + 1);
                operation.remove(i);
                i--;
            }
        }

        if(operation.contains("-")) {
            while (operation.contains("-")) {
                int index = operation.indexOf("-");
                double result = operand.get(index) - operand.get(index+1);
                operand.set(index, result);
                operand.remove(index + 1);
                operation.remove(index);
            }
        }

        if(operation.contains("+")) {
            while (operation.contains("+")) {
                int index = operation.indexOf("+");
                double result = operand.get(index) + operand.get(index+1);
                operand.set(index, result);
                operand.remove(index + 1);
                operation.remove(index);
            }
        }

        if(operation.isEmpty() && operand.size() == 1){
            if(!leftPart.equals("")) {
                if (leftPart.substring(leftPart.length() - 1).equals("t")) {
                    leftPart = leftPart.substring(0, leftPart.length() - 1);
                    operand.set(0, Math.tan(Math.toRadians(operand.get(0))));
                } else if (leftPart.substring(leftPart.length() - 1).equals("c")) {
                    leftPart = leftPart.substring(0, leftPart.length() - 1);
                    operand.set(0, Math.cos(Math.toRadians(operand.get(0))));
                } else if (leftPart.substring(leftPart.length() - 1).equals("s")) {
                    leftPart = leftPart.substring(0, leftPart.length() - 1);
                    operand.set(0, Math.sin(Math.toRadians(operand.get(0))));
                }
            }
            recurse(leftPart + new BigDecimal(operand.get(0)).toPlainString() + rightPart, countOperation);
        }

    }

    public Solution() {
        //don't delete
    }
}
