package org.example;

public class Main {
    public static void main(String[] args) {
        int boardSize = 10;
        BattleshipGameBoard gameBoard = new BattleshipGameBoard(boardSize);

        Battleship ship1 = new Battleship(3);
        Battleship ship2 = new Battleship(4);

        boolean ship1Placed = gameBoard.placeShip(ship1);
        boolean ship2Placed = gameBoard.placeShip(ship2);

//        int ship1X = ship1.getXCoordinate();
//        int ship1Y = ship1.getYCoordinate();

//        int ship2X = ship2.getXCoordinate();
//        int ship2Y = ship2.getYCoordinate();
//
//        System.out.println(ship1X + "" + ship1Y + "" + ship2X + "" + ship2Y);
        gameBoard.printBoard();
    }
}