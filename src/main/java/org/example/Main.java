package org.example;

public class Main {
    public static void main(String[] args) {
        int boardSize = 10;
        BattleshipGameBoard gameBoard = new BattleshipGameBoard(boardSize);
        AttackResult attackResult = new AttackResult();

        Battleship ship1 = new Battleship(3);
        int[] randomCoords1 = gameBoard.generateRandomCoordinates(ship1.getSize());
        boolean ship1Placed = gameBoard.placeShip(ship1, randomCoords1[0], randomCoords1[1], true);

        Battleship ship2 = new Battleship(4);
        int[] randomCoords2 = gameBoard.generateRandomCoordinates(ship2.getSize());
        boolean ship2Placed = gameBoard.placeShip(ship2, randomCoords2[0], randomCoords2[1], false);

        Battleship ship3 = new Battleship(4);
        int[] randomCoords3 = gameBoard.generateRandomCoordinates(ship2.getSize());
        boolean ship3Placed = gameBoard.placeShip(ship3, randomCoords3[0], randomCoords3[1], false);

        gameBoard.hideShipLocations();

        gameBoard.printBoard();

        boolean gameOver = false;

        while (!gameOver) {
            gameOver = attackResult.result(gameBoard);
        }
    }
}