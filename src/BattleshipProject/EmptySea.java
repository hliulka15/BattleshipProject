package BattleshipProject;

public class EmptySea extends Ship {
    private boolean[] hit;
    // class EmptySea extends Ship - Describes a part of the ocean that does not have a ship in it. 
    // While it might seem silly to have the lack of a ship be a type of ship, this trick does simplify a number of things.
    
    public EmptySea() {
        // This constructor sets the inherited length variable to 1.
        setLength(1);
        hit = new boolean[getLength()];
        setHit(getLength());
    }

    @Override
    public boolean[] setHit(int length) {
        return hit;
    }

    @Override
    public boolean[] getHit() {
        return this.hit;
    }

    
    @Override
    public boolean shootAt(int row, int column){
        // This method overrides shootAt(int row, int column) that is inherited from Ship, and always returns false to indicate that nothing was hit.
        return false;
    }
    
    @Override 
    public boolean isSunk() {
        // This method overrides isSunk() that is inherited from Ship, and always returns false to indicate that you didn’t sink anything.
        return false;
    }
    
    @Override
    public String toString() {
        if (getHit()[0] == true) {
            return "-";
        } else {
            return ".";
        }
    }


    @Override
    public String getShipType() {
        // This method just returns the string ”empty”
        return "empty";
    }
    
}
