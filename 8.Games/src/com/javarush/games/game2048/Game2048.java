package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
        gameField = new int[SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void drawScene(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                setCellColoredNumber(i,j,gameField[j][i]);
            }
        }
    }

    private void createNewNumber(){
        if(getMaxTileValue() == 2048){
            win();
        }
        while (true) {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[x][y] == 0) {
                if (getRandomNumber(10) == 9) {
                    gameField[x][y] = 4;
                } else {
                    gameField[x][y] = 2;
                }
                break;
            }
        }
    }

    private Color getColorByValue(int value){
        switch (value){
            case 2: return Color.ANTIQUEWHITE;
            case 4: return Color.ALICEBLUE;
            case 8: return Color.AQUA;
            case 16: return Color.AQUAMARINE;
            case 32: return Color.AZURE;
            case 64: return Color.BEIGE;
            case 128: return Color.BISQUE;
            case 256: return Color.BLANCHEDALMOND;
            case 512: return Color.BLUE;
            case 1024: return Color.BLUEVIOLET;
            case 2048: return Color.CADETBLUE;
        }
        return Color.DARKSEAGREEN;
    }

    private void setCellColoredNumber(int x, int y, int value){
        Color setColor = getColorByValue(value);
        if(value != 0) {
            setCellValueEx(x, y, setColor, String.valueOf(value));
        }else{
            setCellValueEx(x, y, setColor, "");
        }
    }

    private boolean compressRow(int[] row){
        boolean move = false;
        for (int i = 0; i < row.length-1; i++) {
            if(row[i]==0){
                for (int j = i+1; j < row.length; j++) {
                    if(row[j]!=0){
                        row[i] = row[j];
                        row[j] = 0;
                        move = true;
                        break;
                    }
                }
            }
        }
        return move;
    }

    private boolean mergeRow(int[] row){
        boolean merge = false;
        for (int i = 0; i < row.length-1; i++) {
            if(row[i] != 0 && row[i] == row[i+1]){
                row[i] *= 2;
                score+=row[i];
                setScore(score);
                row[i+1] = 0;
                merge = true;
            }
        }
        return merge;
    }

    @Override
    public void onKeyPress(Key key) {
        if(!canUserMove()){
            gameOver();
        }else {
            if (key == Key.LEFT && !isGameStopped) {
                moveLeft();
                drawScene();
            } else if (key == Key.RIGHT && !isGameStopped) {
                moveRight();
                drawScene();
            } else if (key == Key.UP && !isGameStopped) {
                moveUp();
                drawScene();
            } else if (key == Key.DOWN && !isGameStopped) {
                moveDown();
                drawScene();
            } else if(key == Key.SPACE && isGameStopped) {
                isGameStopped = false;
                createGame();
                drawScene();
            }
        }
    }

    private void moveLeft(){
        boolean someMove = false;
        for (int[] ints : gameField) {
            boolean compress1 = compressRow(ints);
            boolean merge = mergeRow(ints);
            boolean compress2 = compressRow(ints);
            if (compress1 || merge || compress2) {
                someMove = true;
            }
        }
        if(someMove){
            createNewNumber();
        }
    }

    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
        int[][] rotatedGameField = new int[SIDE][SIDE];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                rotatedGameField[i][j] = gameField[SIDE - j - 1][i];
            }
        }
        gameField = rotatedGameField;
    }

    private int getMaxTileValue(){
        int maxValue = 0;
        for (int[] ints : gameField) {
            for (int anInt : ints) {
                if (anInt > maxValue) {
                    maxValue = anInt;
                }
            }
        }
        return maxValue;
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You WIN", Color.BLACK, 70);
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "You LOSE", Color.BLACK, 70);
    }

    private boolean canUserMove(){

        for (int i = 0; i < SIDE-1; i++) {
            for (int j = 0; j < SIDE-1; j++) {
                if (gameField[i][j] == 0 ||
                        gameField[i+1][j] == 0 ||
                        gameField[i][j+1] == 0 ||
                        gameField[i+1][j+1] == 0 ||
                        gameField[i][j] == gameField[i+1][j] ||
                        gameField[i][j] == gameField[i][j+1] ||
                        gameField[i+1][j] == gameField[i+1][j+1] ||
                        gameField[i][j+1] == gameField[i+1][j+1]) {
                    return true;
                }

            }
        }


        return false;
    }
}
