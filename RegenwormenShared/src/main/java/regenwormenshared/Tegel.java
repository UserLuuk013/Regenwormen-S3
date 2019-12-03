package regenwormenshared;

public class Tegel {
    private int waarde;
    private boolean zichtbaar;

    public Tegel(int waarde, boolean zichtbaar){
        this.waarde = waarde;
        this.zichtbaar = zichtbaar;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public boolean isZichtbaar() {
        return zichtbaar;
    }

    public void setZichtbaar(boolean zichtbaar) {
        this.zichtbaar = zichtbaar;
    }
}
