package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleshipGameBoard {
    private final char[][] board;
    private final int boardSize;
    private final List<Battleship> ships;

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

    boolean placeShip(Battleship ship, int x, int y, boolean isHorizontal) {
        int shipSize = ship.getSize();

        if ((isHorizontal && x + shipSize > boardSize) || (!isHorizontal && y + shipSize > boardSize)) {
            return false;
        }

        for (int i = 0; i < shipSize; i++) {
            int checkX = isHorizontal ? x + i : x;
            int checkY = isHorizontal ? y : y + i;

            if (board[checkX][checkY] == 'S') {
                return false;
            }
        }

        for (int i = 0; i < shipSize; i++) {
            int placeX = isHorizontal ? x + i : x;
            int placeY = isHorizontal ? y : y + i;

            board[placeX][placeY] = 'S';
        }

        ship.setPosition(x, y);
        ships.add(ship);
        for (Battleship s : ships) {
            System.out.println(s.getXCoordinate());
            System.out.println(s.getYCoordinate());
            System.out.println(s.getSize());
        }

        return true;
    }

    public int[] generateRandomCoordinates(int shipSize) {
        Random random = new Random();
        int x = random.nextInt(boardSize - shipSize + 1);
        int y = random.nextInt(boardSize);
        return new int[] { x, y };
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

    public List<Battleship> getShips() {
        return ships;
    }

    public void hideShipLocations() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = '~';
                }
            }
        }
    }
}
