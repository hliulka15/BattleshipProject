package BattleshipProject;

public class BattleShip extends Ship {
    private boolean[] hit;
    // class BattleShip extends Ship – Describes a battleship - a ship that occupies 8 squares.
    public BattleShip() {
        this.setLength(8);
        hit = new boolean[getLength()];
        setHit(this.getLength());
    }


    @Override
    public boolean[] setHit(int length) {
        return hit;
    }

    @Override
    public boolean[] getHit() {
        return hit;
    }

    @Override
    String getShipType() {
        return "battleship";
    }
    
    
}
