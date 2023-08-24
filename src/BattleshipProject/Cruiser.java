package BattleshipProject;

public class Cruiser extends Ship {
    private boolean[] hit;
    // two 6-square Cruisers
    public Cruiser() {
        this.setLength(6);
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
        return "cruiser";
    }
    
}
