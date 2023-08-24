package BattleshipProject;

public class Destroyer extends Ship {
    private boolean[] hit;

    public Destroyer() {
        this.setLength(4);
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
        return "destroyer";
    }
    
}
