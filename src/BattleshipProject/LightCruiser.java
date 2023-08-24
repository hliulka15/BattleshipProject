package BattleshipProject;

public class LightCruiser extends Ship {
    private boolean[] hit;

    public LightCruiser() {
        this.setLength(5);
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
        return "light cruiser";
    }

}
