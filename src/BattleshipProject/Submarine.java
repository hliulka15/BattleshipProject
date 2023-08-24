package BattleshipProject;

public class Submarine extends Ship {
    private boolean[] hit;

    public Submarine() {
        this.setLength(3);
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
        return "submarine";
    }
    
}
