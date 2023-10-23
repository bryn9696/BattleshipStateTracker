package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleshipGameBoard {
    private final char[][] board;
    private final int boardSize;
    private List<Battleship> ships;

    public BattleshipGameBoard(int size) {
        boardSize = size;
        board = new char[size][size];
        initializeBoard();
        ships = new ArrayList<>();
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

    public boolean takeShot(int x, int y) {
        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize) {
            return false;
        }

        char cell = board[x][y];
        if (cell == 'X' || cell == 'O') {
            return false;
        }

        boolean hit = false;

        for (Battleship ship : ships) {
            if (x >= ship.getXCoordinate() && x < ship.getXCoordinate() + ship.getSize() &&
                    y >= ship.getYCoordinate() && y < ship.getYCoordinate() + 1) {
                // Hit a ship
                hit = true;
                ship.hit();
                board[x][y] = 'X';
                System.out.println("Hit!");
                break;
            }
        }

        if (!hit) {
            board[x][y] = 'O';
            System.out.println("Miss!");
        }

        return true;
    }

}
