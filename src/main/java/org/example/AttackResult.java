package org.example;

public class AttackResult {
    public boolean result(BattleshipGameBoard gameBoard) {
        boolean gameOver = false;

        int[] coOrd = UserInput.askForInput();
        int x = coOrd[0];
        int y = coOrd[1];

        boolean shotTaken = gameBoard.takeShot(x, y);

        if (shotTaken) {
            System.out.println("Shot taken successfully!");

            for (Battleship ship : gameBoard.getShips()) {
                if (ship.getHealth() > 0) {
                    System.out.println("Ship with size " + ship.getSize() + " has " + ship.getHealth() + " health remaining.");
                } else {
                    System.out.println("Ship with size " + ship.getSize() + " is sunk.");
                }
            }

            gameBoard.printBoard();

            boolean allShipsSunk = true;

            for (Battleship ship : gameBoard.getShips()) {
                if (ship.getHealth() > 0) {
                    allShipsSunk = false;
                    break;
                }
            }

            if (allShipsSunk) {
                System.out.println("Congratulations! You've sunk all the computer-controlled ships.");
                gameOver = true;
            }
        } else {
            System.out.println("Invalid shot. Please try again.");
        }
        return gameOver;
    }
}