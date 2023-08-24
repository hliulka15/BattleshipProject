package BattleshipProject;

public class BattleCruiser extends Ship {
    private boolean[] hit;
    // class BattleCruiser extends Ship - Describes a battlecruiser - a ship that occupies 7 squares.
    public BattleCruiser() {
        this.setLength(7);
        hit = new boolean[getLength()];
        setHit(getLength());
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
        return "battle cruiser";
    }
    
}
