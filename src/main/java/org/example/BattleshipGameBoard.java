package org.example;

import java.util.Random;

public class BattleshipGameBoard {
    private final char[][] board;
    private final int boardSize;

    public BattleshipGameBoard(int size) {
        boardSize = size;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '~';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeShip(Battleship ship) {
        Random random = new Random();
        int x = random.nextInt(boardSize);
        int y = random.nextInt(boardSize);

        if (canPlaceShip(ship, x, y)) {
            ship.setPosition(x, y);
            return true;
        } else {
            return false;
        }
    }

    private boolean canPlaceShip(Battleship ship, int x, int y) {

        if (x + ship.getSize() <= boardSize && y + ship.getSize() <= boardSize) {

            for (int i = x; i < x + ship.getSize(); i++) {
                for (int j = y; j < y + ship.getSize(); j++) {
                    if (board[i][j] != '~') {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
