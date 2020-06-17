package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellValue(x,y,"");
                setCellColor(x, y, Color.LIGHTCYAN);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void countMineNeighbors(){
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField[y].length; x++) {
                if(!gameField[x][y].isMine){
                    for (GameObject go : getNeighbors(gameField[x][y])){
                        if(go.isMine) {
                            gameField[x][y].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void openTile(int x, int y){
        if(!gameField[y][x].isOpen && !gameField[y][x].isFlag && !isGameStopped) {
            gameField[y][x].isOpen = true;
            countClosedTiles--;
            setCellColor(x, y, Color.OLIVE);
            if (gameField[y][x].isMine) {
//            setCellValue(x,y,MINE);
//            setCellColor(x,y,Color.RED);
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else {
                score+=5;
                setScore(score);
                if (gameField[y][x].countMineNeighbors == 0) {
                    setCellValue(x, y, "");
                    for (GameObject go : getNeighbors(gameField[y][x])) {
                        if (!go.isOpen) {
                            openTile(go.x, go.y);
                        }
                    }
                } else {
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                }
                if(countClosedTiles == countMinesOnField){
                    win();
                }
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if(isGameStopped){
            restart();
        }else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void markTile(int x, int y){
        if(!isGameStopped) {
            if (!gameField[y][x].isOpen && countFlags != 0 && !gameField[y][x].isFlag) {
                gameField[y][x].isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.YELLOW);
            } else if (gameField[y][x].isFlag) {
                gameField[y][x].isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.LIGHTCYAN);
            }
        }
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.AQUA, "GAME OVER!",Color.BLACK, 50);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.AQUA, "WIN!",Color.BLACK, 50);
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE*SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(score);
        createGame();
    }
}