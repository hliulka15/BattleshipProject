package BattleshipProject;

import java.util.*;

public abstract class Ship {
    //     Since we don’t really care which end of a ship is the bow and which the stern, we will consider all ships to be facing up or left. 
    // Other parts of the ship are in higher-numbered rows or columns.
    // You don’t need to write a constructor for this class–Java will automatically supply one for you (with no arguments).

    private int bowRow; // the row (0 to 19) which contains the bow (front) of the ship.
    private int bowColumn; // the column which contains the bow (front) of the ship.    
    private int length; // the number of squares occupied by the ship. An ”empty sea” location has length 1. 
    private boolean horizontal; // true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.
    private boolean[] hit; // this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.
    public Ocean ocean;

    // public void setOcean(Ocean ocean) {
    //     this.ocean = ocean;
    // }

    // public Ocean getOcean() {
    //     return ocean;
    // }

    public Ship() {
        setLength(8);
        hit = new boolean[this.getLength()];
    }

    public int getBowRow() {
        return bowRow;
    }
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }
    public int getBowColumn() {
        return bowColumn;
    }
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isHorizontal() {
        Random random = new Random();
        horizontal = random.nextBoolean();
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
        horizontal = isHorizontal();
    }

    abstract boolean[] getHit();

    abstract boolean[] setHit(int length);

    public boolean mark (int row, int column) {
        int location = convertToLocation(row, column);
        if (isValidLocation(location)) {
            if ((row == bowRow && column == bowColumn) || getShipType() == "empty") {
                getHit()[0] = true;
            } else if (!horizontal && row == bowRow && column >= bowColumn && column < bowColumn + length) {
                getHit()[column - bowColumn] = true;
            } else if (horizontal && column == bowColumn && row >= bowRow && row < bowRow + length) {
                getHit()[row - bowRow] = true;
            }
        }
        return false;

    }

    abstract String getShipType();

    // This is an abstract method and therefore has no body.


    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (horizontal) {
            for (int c = column; c < column + getLength(); c++) {
                if (!ocean.isLocationValid(row, c) || ocean.isOccupied(row, c) || ocean.isAdjacentOccupied(row, c)) {
                    return false;
                }
            }
        } else {
            for (int r = row; r < row + getLength(); r++) {
                if (!ocean.isLocationValid(r, column) || ocean.isOccupied(r, column) || ocean.isAdjacentOccupied(r, column)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise. 
    // The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), and it must not ”stick out” beyond the array. 
    // Do not actually change either the ship or the Ocean, just says whether it is legal to do so.


    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        setBowRow(row);
        setBowColumn(column);

        if (horizontal) {
            for (int c = column; c < column + length; c++) {
                ocean.setShipArray(row, c, this);
            }
        } else {
            for (int r = row; r < row + length; r++) {
                ocean.setShipArray(r, column, this);
            }
        }
    }

    // ”Puts” the ship in the ocean. This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship, 
    // and it also involves putting a reference to the ship in each of 1 or more locations (up to 8) in the ships array in the Ocean object. 
    // (Note: This will be as many as eight identical references; you can’t refer to a ”part” of a ship, only to the whole ship.)


    public boolean shootAt(int row, int column) {
        int location = convertToLocation(row, column);
        if (isValidLocation(location)) {
            if (row == bowRow && column == bowColumn) {
                getHit()[0] = true;
                return true;
            } else if (!horizontal && row == bowRow && column >= bowColumn && column < bowColumn + length) {
                getHit()[column - bowColumn] = true;
                return true;
            } else if (horizontal && column == bowColumn && row >= bowRow && row < bowRow + length) {
                getHit()[row - bowRow] = true;
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }


    public boolean isValidLocation(int location) {
        return (location >= 0) && (location < 400);
    }

    public int convertToLocation(int row, int column) {
        return row * 20 + column;
        // if (horizontal) {
        //     return Math.abs((bowRow * 20) + column - bowColumn);
        // } else {
        //     return Math.abs((row * 20) + bowColumn - column);
        // }
    }
    // If a part of the ship occupies the given row and column, and the ship hasn’t been sunk, mark that part of the ship as ”hit” 
    // (in the hit array, 0 indicates the bow) and return true, otherwise return false.


    public boolean isSunk() {
        int index = 0;
        while (index < getHit().length) {
            if (getHit()[index] == true) {
                index++;
            } else {
                return false;
            }
            
        }
        return true;
    }

    

    // Return true if every part of the ship has been hit, false otherwise.

    @Override

    public String toString() {
        if (isSunk() == true) {
            return "x";
        }
        else {
            return "S";
        }
        
    
    }

    // Returns a single-character String to use in the Ocean’s print method (see below).
    // This method should return ”x” if the ship has been sunk, ”S” if it has not been sunk. 
    // This method can be used to print out locations in the ocean that have been shot at; it should not be 
    // used to print locations that have not been shot at.
    // Since toString behaves exactly the same for all ship types, it can be moved into the Ship class.
    // Note that the toString method for the EmptySea class has to override the Ship class's implementation.
    //  In order to figure out what needs to be done, please see the description of the print method in the Ocean class.


}
