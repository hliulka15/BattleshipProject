package BattleshipProject;



public class Ocean {
    // This contains a 20x20 array of Ships, representing the ”ocean,” and some methods to manipulate it.
    // Instance variables
    private Ship[][] ships = new Ship[20][20]; // :-Used to quickly determine which ship is in any given location.
    private int shotsFired;  // The total number of shots fired by the user.
    private int hitCount; // The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, 
                            // every hit is counted, even though the additional ”hits” don’t do the user any good.
    private int shipsSunk; //The number of ships sunk. Remember that you have a total of 13 ships

    
    public Ocean() {

        initializeGrid();
    }

    private void initializeGrid() {
        ships = new Ship[20][20];
        for (int row = 0; row < 20; row++) {
            for (int col = 0; col < 20; col++) {
                ships[row][col] = new EmptySea();
            }
        }
    }



    public void setShipArray(int row, int column, Ship ship) {
        ships[row][column] = ship;
    }

    public boolean isLocationValid(int row, int col) {
        return (row >= 0 && row < 20 && col >= 0 && col < 20);
    }


    public void placeAllShipsRandomly() {
        Ship[] shipsToPlace = {
            new BattleShip(),
            new BattleCruiser(),
            new Cruiser(),
            new Cruiser(),
            new LightCruiser(),
            new LightCruiser(),
            new Destroyer(),
            new Destroyer(),
            new Destroyer(),
            new Submarine(),
            new Submarine(),
            new Submarine(),
            new Submarine()
        };

        for (Ship ship : shipsToPlace) {
            boolean placed = false;
            while (!placed) {
                int row = (int) (Math.random() * 20);
                int col = (int) (Math.random() * 20);
                boolean horizontal = Math.random() < 0.5;

                if (ship.okToPlaceShipAt(row, col, horizontal, this)) {
                    ship.placeShipAt(row, col, horizontal, this);
                    placed = true;
                }
            }
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



    public boolean isOccupied(int row, int column) {
        int location = convertToLocation(row, column);
        boolean inBounds = isValidLocation(location);

        if(inBounds){
            if (ships[row][column].getShipType().equals("empty")) {
                return false;
            } else {
                // do not do this! it fucks with setup
                // if (ships[row][column].shootAt(row, column)) {
                //     hitCount++;
                //     if (ships[row][column].isSunk()) {
                //         shipsSunk++;
                //     }
                // }
                return true;
            }
        } else {
            System.out.println("invalid location");
            return false;
        }
    }

    public boolean shootAt(int row, int column) {
        shotsFired++;
        if (ships[row][column].getShipType().equals("empty") || ships[row][column].isSunk()) {
            return false;
        } else {
            // Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. 
            // In addition, this method updates the number of shots that have been fired, and the number of hits. 
            // Note: If a location contains a ”real” ship, shootAt should return true every time the user shoots at that same location. 
            // Once a ship has been ”sunk”, additional shots at its location should return false.
            hitCount++;
            return true;
        }

    }

// Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea), false if it does not. 
// In addition, this method updates the number of shots that have been fired, and the number of hits. 
// Note: If a location contains a ”real” ship, shootAt should return true every time the user shoots at that same location. 
// Once a ship has been ”sunk”, additional shots at its location should return false.

    public boolean isAdjacentOccupied(int row, int column) {
        try {
            // Check the surrounding cells for occupation
            for (int r = row - 1; r <= row + 1; r++) {
                for (int c = column - 1; c <= column + 1; c++) {
                    if (isLocationValid(r, c) && isOccupied(r, c)) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }



    public boolean isGameOver() {
        return shipsSunk == 13;
    }



    public Ship[][] getShipArray(){
        // Returns the 20x20 array of ships. The methods in the Ship class that take an Ocean parameter really need to be able to look at the 
        // contents of this array; the placeShipAt method even needs to modify it. While it is undesirable to allow methods in one class to 
        // directly access instance variables in another class, sometimes there is just no good alternative.
        return ships;
    }



    public void print(){
        //todo horizontal true/false is inverted. fix
 
        System.out.print("   ");
        for (int col = 0; col < 20; col++) {
            System.out.print(getFormattedCoordinate(col) + " ");
        }
        System.out.println();
    
        for (int row = 0; row < 20; row++) {
            System.out.print(getFormattedCoordinate(row) + " ");
            for (int col = 0; col < 20; col++) {
                System.out.print(ships[col][row] + "  "); // Inverted rows and columns
            }
            System.out.println();
        }
        // Helper method to format the coordinate with leading zeros
        
        // Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array, 
        // and column numbers should be displayed along the top. Numbers should be 00 to 19, not 1 to 20.

        // The top left corner square should be 0, 0.
        // Use ’S’ to indicate a location that you have fired upon and hit a (real) ship, ’-’ to indicate a location that you have 
        // fired upon and found nothing there, ’x’ to indicate a location containing a sunken ship,
        // and ’.’ (a period) to indicate a location that you have never fired upon.
        // This is the only method in the Ocean class that does any input/output, and it is never called from within the Ocean class (
        // except possibly during debugging), only from the BattleshipGame class.
    }

    private String getFormattedCoordinate(int coordinate) {
        return String.format("%02d", coordinate);
    }


    public Ship[][] getShips() {
        return ships;
    }
    public void setShips(Ship[][] ships) {
        this.ships = ships;
    }
    // specified
    public int getShotsFired() {
        return shotsFired;
    }
    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }
    // specified
    public int getHitCount() {
        return hitCount;
    }
    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }
    // specified
    public int getShipsSunk() {
        return shipsSunk;
    }
    public void setShipsSunk(int shipsSunk) {
        this.shipsSunk = shipsSunk;
    }

    public void markShot(int row, int column) {
        int location = convertToLocation(row, column);
        boolean inBounds = isValidLocation(location);
        if(inBounds) {
            ships[row][column].mark(row, column);
        }
    }

    
    
}
