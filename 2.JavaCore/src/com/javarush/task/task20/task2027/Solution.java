package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        for (String word :words) {
            for (int i = 0; i <crossword.length ; i++) {
                for (int j = 0; j <crossword[i].length ; j++) {
                    if (word.charAt(0) == crossword[i][j]) {
                        Word foundWord = new Word(word);
                        foundWord.setStartPoint(j,i);
                        // указываем координаты за пределами массива, чтобы потом отфильтровать слова (есть первая буква, но нет слова полностью)
                        foundWord.setEndPoint(-1,-1);
                        Solution solution = new Solution();
                        // вызываем findLast который проверяет слово и устанавливает координаты последней буквы
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1,  0,  1);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1,  0, -1);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1,  1,  0);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1, -1,  0);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1, -1, -1);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1, -1,  1);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1,  1,  1);
                        solution.findLast(crossword, foundWord, foundWord.startX, foundWord.startY, 1,  1, -1);
                        if (foundWord.endX!=-1&& foundWord.endY!=-1){
                            list.add(foundWord);
                            break;
                        }
                    }
                }
            }
        }
        return list;
    }

    public void findLast(int[][] crossword, Word w, int startX, int startY, int nextLetter, int nextX, int nextY){
        try{
            if(crossword[startY+nextY][startX+nextX]==w.text.charAt(nextLetter)) {
                if (nextLetter==w.text.length()-1) {
                    w.setEndPoint(startX + nextX, startY + nextY);
                } else {
                    findLast(crossword, w, startX + nextX, startY + nextY, ++nextLetter, nextX, nextY);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){

        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
