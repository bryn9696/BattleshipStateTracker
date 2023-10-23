package org.example;

public class Main {
    public static void main(String[] args) {
        int boardSize = 10;
        BattleshipGameBoard gameBoard = new BattleshipGameBoard(boardSize);

        gameBoard.printBoard();
    }
}