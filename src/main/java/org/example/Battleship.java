package org.example;

public class Battleship {
    private final int size;
    private int health;
    private int xCoordinate;
    private int yCoordinate;
    private boolean isSunk;

    public Battleship(int size) {
        this.size = size;
        this.health = size;
//        this.xCoordinate = x;
//        this.yCoordinate = y;
        this.isSunk = false;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setPosition(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void hit() {
        if (!isSunk) {
            health--;
            if (health == 0) {
                isSunk = true;
            }
        }
    }
}
